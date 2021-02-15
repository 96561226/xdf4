package com.aaa.springcloud.controller;

import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.springcloud.service.api.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Transactional
public class FormController {

    @Autowired
    FormService formService;


    @GetMapping("/formapi/fstates")
    public ReturnObj selFormStateAll(){
        return formService.selFormStateAll();
    };
    //根据状态id查询状态名字
    @GetMapping("/formapi/fstate")
    public ReturnObj selFormStateById(@RequestParam("state_id")Long state_id){
        return formService.selFormStateById(state_id);
    };

    //查询所有任务状态信息
    @GetMapping("/formapi/taskStates")
    public ReturnObj selTaskStateAll(){
        return formService.selTaskStateAll();
    };

    //查询所有报告状态信息
    @GetMapping("/formapi/statementStates")
    public ReturnObj selStatementStateAll(){
        return formService.selStatementStateAll();
    };


    @GetMapping("/formapi/selnoapi")
    public ReturnObj selno(@RequestParam("noName") String noName,@RequestParam("tableName") String tableName,@RequestParam("idName") String idName){
       return formService.selno(noName,tableName,idName);
    };

}
