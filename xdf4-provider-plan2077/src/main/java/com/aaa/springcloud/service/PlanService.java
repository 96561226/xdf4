package com.aaa.springcloud.service;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.plans.TbPlanCharge;
import com.aaa.pojo.plans.TbPlanScheduling;
import com.aaa.pojo.plans.TbPlanType;
import com.aaa.searchpojo.SearchPlan;
import com.aaa.pojo.plans.TbPlan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PlanService {
    ReturnObj selectPlanAll(SearchPlan plan);

    //审批计划表
    ReturnObj sqPlan(TbPlan plan, Long emp_id);

    //添加工作计划
    ReturnObj insertPlan(TbPlan plan,List<Long> aemps,List<Long> cemps,List<TbPlanScheduling> schedulings);

    //修改工作计划
    int updPlan(TbPlan plan);

    //删除工作计划
    int delPlan(Long planId);

    //查询工作计划类型
    List<TbPlanType> selPlanTypes();

}
