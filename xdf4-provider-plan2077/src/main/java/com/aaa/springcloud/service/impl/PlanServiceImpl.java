package com.aaa.springcloud.service.impl;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.plans.*;
import com.aaa.searchpojo.SearchPlan;
import com.aaa.springcloud.mapper.PlanActionMapper;
import com.aaa.springcloud.mapper.PlanChargeMapper;
import com.aaa.springcloud.mapper.PlanMapper;
import com.aaa.springcloud.mapper.PlanSchedulingMapper;
import com.aaa.springcloud.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@Transactional
public class PlanServiceImpl implements PlanService {
    @Autowired
    PlanMapper planMapper;
    @Autowired
    PlanChargeMapper planChargeMapper;
    @Autowired
    PlanActionMapper planActionMapper;
    @Autowired
    PlanSchedulingMapper planSchedulingMapper;


    @Override
    public ReturnObj selectPlanAll(SearchPlan plan) {
        List<PlanVo> pvs =planMapper.selPlanAll(plan);
        return new ReturnObj(0,"",pvs.size(),pvs);
    }

    @Override
    public ReturnObj sqPlan(TbPlan plan, Long emp_id) {

        int i = planMapper.updPlan(plan);
        if (i==0){
            return new ReturnObj(400,"审批计划表失败",i,null);
        }
        //修改审批人状态
        TbPlanCharge tbPlanCharge = new TbPlanCharge();

        tbPlanCharge.setCharge_emp_id(emp_id);
        tbPlanCharge.setPid(plan.getPlan_id());
        tbPlanCharge.setState(2);

        int j = planChargeMapper.updPlanCharge(tbPlanCharge);
        if (j==0){
            return new ReturnObj(400,"审批人状态异常",i,null);
        }

        return new ReturnObj(200,"审批完成",i,i);
    }

    @Override
    public ReturnObj insertPlan(TbPlan plan, List<Long> aemps, List<Long> cemps,List<TbPlanScheduling> schedulings) {
        //验证信息是否完整
        if (null==plan){
            return new ReturnObj(400,"工作计划表状态异常",null,null);
        }
        if (null==aemps || aemps.size()==0){
            return new ReturnObj(400,"执行人信息状态异常",null,null);
        }
        if (null==cemps || cemps.size()==0){
            return new ReturnObj(400,"审批责任人信息状态异常",null,null);
        }

        //添加
        int i = planMapper.insertPlan(plan);
        if (i==0){
            return new ReturnObj(400,"添加计划失败",null,null);
        }
        //验证是否添加成功
        SearchPlan searchPlan = new SearchPlan();
        searchPlan.setPlan_no(plan.getPlan_no());
        List<PlanVo> planVos = planMapper.selPlanAll(searchPlan);
        if (null==planVos || planVos.size()==0){
            return new ReturnObj(400,"添加成功，查询异常",null,null);
        }
        //取出刚添加的计划
        PlanVo planVo=planVos.get(0);
        Long plan_id = planVo.getPlan_id();
        //添加执行人
        for (Long aemp : aemps) {
            TbPlanAction action = new TbPlanAction();
            action.setAction_emp_id(aemp);
            action.setPid(plan_id);
            int j = planActionMapper.insertPlanAction(action);
            if (j==0){
                return new ReturnObj(400,"添加执行人失败",null,null);
            }
        }
        //添加责任人
        for (Long cemp : cemps) {
            TbPlanCharge charge = new TbPlanCharge();
            charge.setPid(plan_id);
            charge.setCharge_emp_id(cemp);
            int j = planChargeMapper.insertPlanCharge(charge);
            if (j==0){
                return new ReturnObj(400,"添加审批责任人失败",null,null);
            }
        }
        //添加计划事项

        for (TbPlanScheduling scheduling : schedulings) {
            scheduling.setPid(plan_id);
            int j = planSchedulingMapper.insertPlanScheduling(scheduling);
            if (j==0){
                return new ReturnObj(400,"添加计划事项失败",null,null);
            }
        }

        return new ReturnObj(200,"一切OK",0,"success");
    }

    @Override
    public int updPlan(TbPlan plan) {
        return planMapper.updPlan(plan);
    }

    @Override
    public int delPlan(Long planId) {
        return planMapper.delPlan(planId);
    }

    @Override
    public List<TbPlanType> selPlanTypes() {
        return planMapper.selPlanTypes();
    }
}
