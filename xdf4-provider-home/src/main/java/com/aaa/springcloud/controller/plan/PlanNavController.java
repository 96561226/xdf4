package com.aaa.springcloud.controller.plan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlanNavController {
    @RequestMapping("/plan/myPlanPage")
    public String toMyPlanIndex(){
        return "plansPage/plan_myIndex";
    }

    @RequestMapping("/plan/allPlanPage")
    public String toPlanIndex(){
        return "plansPage/planIndex";
    }

    @RequestMapping("/plan/myTaskPage")
    public String toMyTaskIndex(){
        return "plansPage/task_myIndex";
    }

    @RequestMapping("/plan/allTaskPage")
    public String toTaskIndex(){
        return "plansPage/taskIndex";
    }

    @RequestMapping("/plan/myStatementPage")
    public String toMyStatementIndex(){
        return "plansPage/statement_myIndex";
    }

    @RequestMapping("/plan/allStatementPage")
    public String toStatementIndex(){
        return "plansPage/statementIndex";
    }
}
