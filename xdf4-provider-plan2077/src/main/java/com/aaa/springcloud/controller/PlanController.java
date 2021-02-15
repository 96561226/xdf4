package com.aaa.springcloud.controller;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.plans.TbPlanCharge;
import com.aaa.pojo.plans.TbPlanScheduling;
import com.aaa.pojo.plans.TbPlanType;
import com.aaa.searchpojo.SearchPlan;
import com.aaa.pojo.plans.TbPlan;
import com.aaa.springcloud.service.PlanService;
import com.aaa.springcloud.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanController extends BaseController {
    @Autowired
    PlanService planService;

    //条件查询工作计划
    @RequestMapping("/plans")
    public ReturnObj selectAll(@RequestBody SearchPlan plan){
        ReturnObj obj = planService.selectPlanAll(plan);
        System.out.println("***************"+obj.getData());
        return obj;
    }

    //审批工作计划
    @PostMapping("/spplan")
    public ReturnObj spPlan(@RequestBody TbPlan plan,@RequestParam("emp_id") Long emp_id){
        ReturnObj obj = planService.sqPlan(plan,emp_id);
        return obj;
    }

    @PostMapping("/insertPlan")
    public ReturnObj insertPlan( @RequestBody TbPlan plan, @RequestParam("aemps")List<Long> aemps,
                                 @RequestParam("cemps")List<Long> cemps,
                                 @RequestParam("plan_schedulings")String[] plan_schedulings,@RequestParam("plan_sadates")String[] plan_sadates) {
        List<TbPlanScheduling> schedulings = new ArrayList<>();
        for (int i=0;i<plan_schedulings.length;i++){
            TbPlanScheduling tbPlanScheduling = new TbPlanScheduling();
            tbPlanScheduling.setScheduling(plan_schedulings[i]);
            tbPlanScheduling.setAdate(parseDate(plan_sadates[i]));
            schedulings.add(tbPlanScheduling);
        }
        return planService.insertPlan(plan,aemps,cemps,schedulings);
    }

    @PostMapping("/updPlan")
    public ReturnObj updPlan(@RequestBody TbPlan plan) {
        int i = planService.updPlan(plan);
        if (i==0){
            return new ReturnObj(400,"操作失败",i,null);
        }
        return new ReturnObj(200,"操作成功",i,i);
    }

    @DeleteMapping("/delPlan")
    public ReturnObj delPlan(@RequestParam("planId") Long planId) {
        int i = planService.delPlan(planId);
        if (i==0){
            return new ReturnObj(400,"操作失败",i,null);
        }
        return new ReturnObj(200,"操作成功",i,i);
    }

    @GetMapping("/selPlanTypes")
    public ReturnObj selPlanTypes() {
        List<TbPlanType> tbPlanTypes = planService.selPlanTypes();
        if (null==tbPlanTypes){
            return new ReturnObj(400,"查询失败",null,tbPlanTypes);
        }
        return new ReturnObj(200,"查询成功",tbPlanTypes.size(),tbPlanTypes);
    }

}
