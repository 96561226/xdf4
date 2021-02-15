package com.aaa.controller;

import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formapi")
public class FormController {
    @Autowired
    FormService formService;

    //查询所有申请状态信息
    @GetMapping("/fstates")
    public ReturnObj selFormStateAll(){
        return formService.selFormStateAll();
    };

    //查询所有任务状态信息
    @GetMapping("/taskStates")
    public ReturnObj selTaskStateAll(){
        return formService.selTaskStateAll();
    };

    //查询所有报告状态信息
    @GetMapping("/statementStates")
    public ReturnObj selStatementStateAll(){return formService.selStatementStateAll();};

    //根据状态id查询状态名字
    @GetMapping("/fstate")
    public ReturnObj selFormStateById(@RequestParam("state_id") Long state_id){
        return formService.selFormStateById(state_id);
    };

    @GetMapping("/selnoapi")
    public ReturnObj selno(@RequestParam("noName")String noName,@RequestParam("tableName") String tableName,@RequestParam("idName") String idName){
        return formService.selNo(noName,tableName,idName);
    }

    //查询审批人
    @GetMapping("/selapprover")
    public List<Long> selApprover(@RequestParam("dept_id") Long dept_id){
        return formService.selApprover(dept_id);
    }

}
