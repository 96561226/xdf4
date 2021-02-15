package com.aaa.springcloud.controller.systemmaster;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SysMasterNavController {
    @RequestMapping("/sysmaster/deptIndex")
    public String deptIndex(){
        return "systemmaster/depts/deptIndex";
    }

    @RequestMapping("/sysmaster/roleIndex")
    public String roleIndex(){
        return "systemmaster/roles/roleIndex";
    }

    @RequestMapping("/sysmaster/empIndex")
    public String empIndex(){
        return "systemmaster/emps/empIndex";
    }

    @RequestMapping("/sysmaster/updPwdIndex")
    public String updPwdIndex(){
        return "systemmaster/emps/updPwd";
    }

    @RequestMapping("/sysmaster/transactionIndex")
    public String transactionIndex(){
        return "systemmaster/transaction/transactionIndex";
    }

    @RequestMapping("/sysmaster/roletransactionIndex")
    public String roletransactionIndex(){
        return "systemmaster/roletransaction/roletransactionIndex";
    }
}
