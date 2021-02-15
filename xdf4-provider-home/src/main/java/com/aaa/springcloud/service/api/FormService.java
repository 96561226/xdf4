package com.aaa.springcloud.service.api;

import com.aaa.pojo.ReturnObj;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "XDF4-API-DAO",contextId = "formId")
public interface FormService {

    @GetMapping("/formapi/fstates")
    public ReturnObj selFormStateAll();

    //查询所有任务状态信息
    @GetMapping("/formapi/taskStates")
    public ReturnObj selTaskStateAll();

    //查询所有报告状态信息
    @GetMapping("/formapi/statementStates")
    public ReturnObj selStatementStateAll();

    //根据状态id查询状态名字
    @GetMapping("/formapi/fstate")
    public ReturnObj selFormStateById(@RequestParam("state_id")Long state_id);

    @GetMapping("/formapi/selnoapi")
    public ReturnObj selno(@RequestParam("noName") String noName,@RequestParam("tableName") String tableName,@RequestParam("idName") String idName);
}
