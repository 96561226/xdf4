package com.aaa.springcloud.controller.plan;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.aaa.pojo.Emp;
import com.aaa.pojo.plans.TbPlan;
import com.aaa.pojo.plans.TbPlanCharge;
import com.aaa.pojo.plans.TbPlanScheduling;
import com.aaa.searchpojo.SearchPlan;
import com.aaa.pojo.ReturnObj;
import com.aaa.springcloud.service.api.EmpService;
import com.aaa.springcloud.service.api.FormService;
import com.aaa.springcloud.service.objectplan.PlanService;
import com.aaa.springcloud.util.BaseController;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class PlanController extends BaseController {
    @Autowired
    PlanService planService;

    @Autowired
    EmpService empService;

    @Autowired
    FormService formService;

    //查询工作计划
    @RequestMapping(value = "/consumer/plan/plans")
    public ReturnObj plans(SearchPlan plan){
        return planService.plans(plan);
    }
    //返回当前最新的工作计划编号
    @RequestMapping(value = "/consumer/plan/planNo")
    public ReturnObj planNo(){
        return formService.selno("JS-","tb_plan","plan_id");
    }

    @PostMapping(value = "/consumer/plan/spplan")
    public ReturnObj spplan(TbPlan plan){

        Authentication au = SecurityContextHolder.getContext().getAuthentication();
        Object[] array = au.getAuthorities().toArray();

        Long emp_id = Long.valueOf(array[0].toString()) ;
        String emp_no = array[1].toString();

        Emp emp = empService.selectByNo(emp_no);
        if (null==emp || null==emp.getEmp_id()){
            return new ReturnObj(400,"非法操作",null,null);
        }

        return planService.spPlan(plan,emp_id);
    }

    @PostMapping("/consumer/plan/insertPlan")
    public ReturnObj insertPlan(TbPlan plan, String[] action_emps, String[] charge_emps,String[] plan_schedulings,String[] plan_sadates){
        Authentication au = SecurityContextHolder.getContext().getAuthentication();
        Object[] array = au.getAuthorities().toArray();
        Long emp_id = Long.valueOf(array[0].toString()) ;

        //完善工作计划详情
        plan.setEmp_id(emp_id);
        plan.setCdate(new Date());

        List<Long> aemps = new ArrayList<>();
        for (String action_emp : action_emps) {
            aemps.add(Long.valueOf(action_emp));
        }

        List<Long> cemps = new ArrayList<>();
        for (String charge_emp : charge_emps) {
            cemps.add(Long.valueOf(charge_emp));
        }
        List<TbPlanScheduling> schedulings = new ArrayList<>();
        for (int i=0;i<plan_schedulings.length;i++){
            TbPlanScheduling tbPlanScheduling = new TbPlanScheduling();
            tbPlanScheduling.setScheduling(plan_schedulings[i]);
            tbPlanScheduling.setAdate(parseDate(plan_sadates[i]));
            schedulings.add(tbPlanScheduling);
        }

        return planService.insertPlan(plan,aemps,cemps,plan_schedulings,plan_sadates);
    };



    @GetMapping("/consumer/plan/selPlanTypes")
    public ReturnObj selPlanTypes(){
        return planService.selPlanTypes();
    };
}
