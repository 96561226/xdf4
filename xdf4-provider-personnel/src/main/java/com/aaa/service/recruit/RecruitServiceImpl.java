package com.aaa.service.recruit;

import com.aaa.mapper.recruit.RecruitApproverMapper;
import com.aaa.mapper.recruit.RecruitNotifyMapper;
import com.aaa.mapper.recruit.RecruitMapper;
import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.personnel.*;
import com.aaa.service.Emp.EmpService;
import com.aaa.service.Emp.FormService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RecruitServiceImpl implements RecruitService {
    @Autowired
    RecruitMapper recruitMapper;
    @Autowired
    RecruitNotifyMapper recruitNotifyMapper;
    @Autowired
    RecruitApproverMapper recruitApproverMapper;
    @Autowired
    FormService formService;
    @Autowired
    EmpService empService;

    @Override
    public int addRecruit(TbRecruit recruit) {
        Long dept_id = selectDeptIdByEmpId(recruit.getEmpId());
        recruit.setDeptId(dept_id);
        int i = recruitMapper.addRecruit(recruit);
        Long recruitId = selectRecruitNo(recruit);
        List<Long> longs = formService.selApprover(dept_id);
        for (int j = 0; j < longs.size(); j++) {
            if (longs.get(j) != recruit.getEmpId()) {
                i = recruitNotifyMapper.insertRecruitNotify(new TbRecruitNotify(recruitId, longs.get(j)));
            }
        }
        return i;
    }

    @Override
    public Long selectDeptIdByEmpId(Long empId) {
        return recruitMapper.selectDeptIdByEmpId(empId);
    }

    @Override
    public int updateRecruit(TbRecruit tbRecruit) {
        SearchRecruit recruit = new SearchRecruit();
        recruit.setRecruitId(Long.valueOf(tbRecruit.getRecruitId()));
        List<TbRecruitVo> tbRecruitVos = recruitMapper.selectRecruit(recruit);
        if (tbRecruitVos.get(0).getState() == 1){
            return recruitMapper.updateRecruit(tbRecruit);
        }else {
            return 0;
        }
    }

    @Override
    public int cancellationRecruits(int[] ids) {
        int result = 0;
        for (int i = 0; i < ids.length; i++) {
            TbRecruit recruit = new TbRecruit();
            recruit.setState(Long.valueOf(4));
            recruit.setRecruitId(Long.valueOf(ids[i]));
            result = updateRecruit(recruit);
        }
        return result;
    }

    @Override
    public int insertRecruitApprover(TbRecruitApprover approver) {
        return recruitApproverMapper.insertRecruitApprover(approver);
    }

    @Override
    public Long selectRecruitNo(TbRecruit recruit) {
        SearchRecruit searchRecruit = new SearchRecruit(recruit);
        List<TbRecruitVo> tbRecruitVos = recruitMapper.selectRecruit(searchRecruit);
        return tbRecruitVos.get(0).getRecruitId();
    }

    @Override
    public String selNo(String noName) {
        return recruitMapper.selNo(noName);
    }

    @Override
    public ReturnObj selectRecruit(SearchRecruit recruit) {
        int currentPage = recruit.getPage() == null ? 1:recruit.getPage();
        int pageSize = recruit.getLimit() == null ? 3:recruit.getLimit();
        PageHelper.startPage(currentPage,pageSize);
        List<TbRecruitVo> es =recruitMapper.selectRecruit(recruit);
        PageInfo<TbRecruitVo> pageinfo = new PageInfo<TbRecruitVo>(es);
        Integer total = Integer.valueOf(pageinfo.getTotal()+"");
        List<TbRecruitVo> list = pageinfo.getList();
        return new ReturnObj(0,"success",total,list);
    }

    @Override
    public ReturnObj approveRecruit(TbRecruit recruit, Long emp_id) {
        //修改招聘表状态
        int i = recruitMapper.updateRecruit(recruit);
        if (i==0){
            return new ReturnObj(400,"审批失败",i,null);
        }

        //修改审批人状态
        TbRecruitApprover approver = new TbRecruitApprover();
        approver.setEmpId(emp_id);
        approver.setRecruitId(recruit.getRecruitId());
        int j = recruitApproverMapper.updateState(approver);
        if (j==0){
            return new ReturnObj(400,"审批人状态异常",i,null);
        }

        return new ReturnObj(200,"审批完成",i,i);
    }
}
