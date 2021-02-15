package com.aaa.service.dimission;

import com.aaa.mapper.dimission.DimissionApproverMapper;
import com.aaa.mapper.dimission.DimissionMapper;
import com.aaa.mapper.dimission.DimissionNotifyMapper;
import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.personnel.*;
import com.aaa.service.Emp.EmpService;
import com.aaa.service.Emp.FormService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DimissionServiceImpl implements DimissionService {
    @Autowired
    DimissionMapper dimissionMapper;
    @Autowired
    DimissionApproverMapper approverMapper;
    @Autowired
    DimissionNotifyMapper notifyMapper;
    @Autowired
    FormService formService;
    @Autowired
    EmpService empService;
    @Override
    public int addDimission(TbDimission dimission) {
        int i = dimissionMapper.addDimission(dimission);
        Long dimissionId = selectDimissionNo(dimission);
        List<Long> longs = formService.selApprover(dimission.getDeptId());
        for (int j = 0; j < longs.size(); j++) {
            if (longs.get(j) != dimission.getEmpId()){
                i = notifyMapper.insertDimissionNotify(new TbDimissionNotify(dimissionId,longs.get(j)));
            }
        }

        return i;
    }

    @Override
    public int updateDimission(TbDimission tbDimission) {
        SearchDimission dimission = new SearchDimission();
        dimission.setDimissionId(Long.valueOf(tbDimission.getDimissionId()));
        List<TbDimissionVo> tbDimissionVos = dimissionMapper.selectDimission(dimission);
        if (tbDimissionVos.get(0).getState() == 1){
            return dimissionMapper.updateDimission(tbDimission);
        }else {
            return 0;
        }
    }

    @Override
    public int cancellationDimissions(int[] ids) {
        int result = 0;
        for (int i = 0; i < ids.length; i++) {
            TbDimission dimission = new TbDimission();
            dimission.setState(Long.valueOf(4));
            dimission.setDimissionId(Long.valueOf(ids[i]));
            result = updateDimission(dimission);
        }
        return result;
    }

    @Override
    public Long selectDimissionNo(TbDimission dimission) {
        SearchDimission searchDimission = new SearchDimission();
        searchDimission.setDimissionNo(dimission.getDimissionNo());
        List<TbDimissionVo> tbDimissionVos = dimissionMapper.selectDimission(searchDimission);
        return tbDimissionVos.get(0).getDimissionId();
    }

    @Override
    public int insertDimissionApprover(TbDimissionApprover approver) {
        return approverMapper.insertDimissionApprover(approver);
    }

    @Override
    public String selDimissionNo(String noName) {
        return dimissionMapper.selNo(noName);
    }

    @Override
    public ReturnObj selectDimission(SearchDimission dimission) {
        int currentPage = dimission.getPage() == null ? 1:dimission.getPage();
        int pageSize = dimission.getLimit() == null ? 3:dimission.getLimit();
        PageHelper.startPage(currentPage,pageSize);
        List<TbDimissionVo> dimissions = dimissionMapper.selectDimission(dimission);
        PageInfo<TbDimissionVo> pageinfo = new PageInfo<TbDimissionVo>(dimissions);
        Integer total = Integer.valueOf(pageinfo.getTotal()+"");
        List<TbDimissionVo> list = pageinfo.getList();
        return new ReturnObj(0,"success",total,list);
    }

    @Override
    public List<TbDimissionType> selectDimissionTypeAll() {
        return dimissionMapper.selectTypeAll();
    }

    @Override
    public ReturnObj approveDimission(TbDimission dimission, Long emp_id) {
        //修改招聘表状态
        int i = dimissionMapper.updateDimission(dimission);
        if (i==0){
            return new ReturnObj(400,"审批失败",i,null);
        }
        Emp emp = new Emp();
        emp.setEmp_id(dimission.getEmpId());
        emp.setState(3);
        empService.updEmp(emp);
        //修改审批人状态
        TbDimissionApprover approver = new TbDimissionApprover();
        approver.setEmpId(emp_id);
        approver.setDimissionId(dimission.getDimissionId());
        int j = approverMapper.updateState(approver);
        if (j==0){
            return new ReturnObj(400,"审批人状态异常",i,null);
        }

        return new ReturnObj(200,"审批完成",i,i);
    }
}
