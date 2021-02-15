package com.aaa.springcloud.service.objectplan;

import com.aaa.pojo.plans.TbPlan;
import com.aaa.pojo.plans.TbPlanCharge;
import com.aaa.pojo.plans.TbPlanScheduling;
import com.aaa.pojo.plans.TbPlanType;
import com.aaa.searchpojo.SearchPlan;
import com.aaa.pojo.ReturnObj;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(value = "XDF4-PROVIDE-OBJECTPLAN",contextId = "planId")
public interface PlanService {
    @RequestMapping(value = "/plan/plans")
    public ReturnObj plans(@RequestBody SearchPlan plan);

    @PostMapping("/plan/spplan")
    public ReturnObj spPlan(@RequestBody TbPlan plan, @RequestParam("emp_id") Long emp_id);

    @PostMapping("/plan/insertPlan")
    public ReturnObj insertPlan(
            @RequestBody TbPlan plan, @RequestParam("aemps")List<Long> aemps,
            @RequestParam("cemps")List<Long> cemps,
            @RequestParam("plan_schedulings")String[] plan_schedulings,@RequestParam("plan_sadates")String[] plan_sadates);

    @PostMapping("/plan/updPlan")
    public ReturnObj updPlan(@RequestBody TbPlan plan);

    @DeleteMapping("/plan/delPlan")
    public ReturnObj delPlan(@RequestParam("planId") Long planId);

    @GetMapping("/plan/selPlanTypes")
    public ReturnObj selPlanTypes();
}
