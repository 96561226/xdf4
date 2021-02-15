package com.aaa.service.travelling;

import com.aaa.mapper.travelling.TravellingApproverMapper;
import com.aaa.mapper.travelling.TravellingContentMapper;
import com.aaa.mapper.travelling.TravellingNotifyMapper;
import com.aaa.mapper.travelling.TravellingMapper;
import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.finance.*;
import com.aaa.pojo.personnel.TbDimissionApprover;
import com.aaa.service.Emp.EmpService;
import com.aaa.service.Emp.FormService;
import com.aaa.service.income.IncomeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service
@Transactional
public class TravellingServiceImpl implements TravellingService {
    @Resource
    TravellingMapper travellingMapper;
    @Resource
    TravellingNotifyMapper travellingNotifyMapper;
    @Resource
    TravellingApproverMapper travellingApproverMapper;
    @Resource
    TravellingContentMapper travellingContentMapper;
    @Autowired
    FormService formService;
    @Autowired
    EmpService empService;
    @Autowired
    IncomeService incomeService;
    @Override
    public int addTravelling(TbTravelling travelling) {
        Long dept_id = selectDeptIdByEmpId(travelling.getEmpId());
        travelling.setDeptId(dept_id);
        int result=travellingMapper.addTravelling(travelling);
        Long travellingId = selectTravellingByNo(travelling);
        List<Long> longs = formService.selApprover(dept_id);
        for (int i = 0; i < longs.size(); i++) {
            if (longs.get(i) != travelling.getEmpId()){
                result=addNotify(new TbTravellingNotify(longs.get(i), travellingId));
            }
        }
        return result;
    }

    @Override
    public int addContents(TbTravellingContent content) {
       return travellingContentMapper.insertTravellingContent(content);
    }

    @Override
    public int addApprover(TbTravellingApprover approver) {
        return travellingApproverMapper.insertTravellingApprover(approver);
    }

    @Override
    public int addNotify(TbTravellingNotify notify) {
        return travellingNotifyMapper.insertTravellingNotify(notify);
    }

    @Override
    public Long selectTravellingByNo(TbTravelling travelling) {
        SearchTravelling searchTravelling = new SearchTravelling(travelling);
        List<TbTravellingVo> tbTravellingVos = travellingMapper.selectTravelling(searchTravelling);
        return tbTravellingVos.get(0).getTravellingId();
    }

    @Override
    public String selTravellingNo() {
        return travellingContentMapper.selTravellingNo();
    }

    @Override
    public Long selectDeptIdByEmpId(Long empId) {
        return travellingMapper.selectDeptIdByEmpId(empId);
    }

    @Override
    public int updateTravelling(TbTravelling tbTravelling) {
        SearchTravelling travelling = new SearchTravelling();
        travelling.setTravellingId(Long.valueOf(tbTravelling.getTravellingId()));
        List<TbTravellingVo> tbRecruitVos = travellingMapper.selectTravelling(travelling);
        if (tbRecruitVos.get(0).getState() == 1){
            return travellingMapper.updateTravelling(tbTravelling);
        }else {
            return 0;
        }
    }

    @Override
    public int cancellationTravellings(int[] ids) {
        int result = 0;
        for (int i = 0; i < ids.length; i++) {
            TbTravelling travelling = new TbTravelling();
            travelling.setTravellingId(Long.valueOf(ids[i]));
            travelling.setState(Long.valueOf(4));
            result = updateTravelling(travelling);
        }
        return result;
    }

    @Override
    public List<TbTravellingContent> selectTravellingContents(Integer id) {
        return travellingContentMapper.selectTravellingContentById(id);
    }

    @Override
    public List<TbTravellingNotifyVo> selectTravellingNotifys(Integer id) {
        return travellingNotifyMapper.selectTravellingNotify(id);
    }

    @Override
    public ReturnObj selectTravelling(SearchTravelling travelling) {
        int currentPage = travelling.getPage() == null ? 1:travelling.getPage();
        int pageSize = travelling.getLimit() == null ? 3:travelling.getLimit();
        PageHelper.startPage(currentPage,pageSize);
        List<TbTravellingVo> bs =travellingMapper.selectTravelling(travelling);
        PageInfo<TbTravellingVo> pageinfo = new PageInfo<TbTravellingVo>(bs);
        Integer total = Integer.valueOf(pageinfo.getTotal()+"");
        List<TbTravellingVo> list = pageinfo.getList();
        return new ReturnObj(0,"success",total,list);
    }

    @Override
    public ReturnObj approveTravelling(TbTravelling travelling, Long emp_id) {
        //修改招聘表状态
        int i = travellingMapper.updateTravelling(travelling);
        if (i==0){
            return new ReturnObj(400,"审批失败",i,null);
        }
        if (travelling.getState() == 2){
            addIncome(travelling.getTravellingId(), emp_id);
        }
        //修改审批人状态
        TbTravellingApprover approver = new TbTravellingApprover();
        approver.setEmpId(emp_id);
        approver.setTravellingId(travelling.getTravellingId());
        int j = travellingApproverMapper.updateApproverState(approver);
        if (j==0){
            return new ReturnObj(400,"审批人状态异常",i,null);
        }

        return new ReturnObj(200,"审批完成",i,i);
    }

    /*审批完成后添加财务信息*/
    public ReturnObj addIncome(Long travellingId,Long emp_id){
        ReturnObj object;
        SearchTravelling searchTravelling = new SearchTravelling();
        searchTravelling.setTravellingId(travellingId);
        ReturnObj obj = selectTravelling(searchTravelling);
        List<TbTravellingVo> data = (List<TbTravellingVo>)obj.getData();
        TbTravellingVo travellingVo = data.get(0);
        List<TbTravellingContent> travellingContents = travellingVo.getTravellingContents();
        Double money= 0.0;
        for (int i = 0; i < travellingContents.size(); i++) {
            Double tramp = travellingContents.get(i).getTramp();
            Double city = travellingContents.get(i).getCity();
            Double stay = travellingContents.get(i).getStay();
            Double evection = travellingContents.get(i).getEvection();
            Double others = travellingContents.get(i).getOthers();
            money+= tramp+city+stay+evection+others;
        }
        TbIncome income = new TbIncome();
        income.setDeptId(travellingVo.getDeptId());
        income.setEmpId(travellingVo.getEmpId());
        income.setGathering(Long.valueOf(1));
        income.setIncomeDeclare("差旅费报销");
        income.setInvolveType(Long.valueOf(2));
        income.setRegister(emp_id);
        income.setMoney(money);
        income.setState(Long.valueOf(2));
        return incomeService.addIncome(income);
    }

}
