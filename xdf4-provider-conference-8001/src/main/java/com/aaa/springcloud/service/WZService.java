package com.aaa.springcloud.service;

import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "XDF4-API-DAO",contextId = "empId")
public interface WZService {
    @GetMapping("/emps/selall")
    public List<Emp> selectAll();
    @GetMapping("/formapi/selnoapi")
    public ReturnObj selno(@RequestParam("noName") String noName, @RequestParam("tableName") String tableName, @RequestParam("idName") String idName);
    //查询审批人
    @GetMapping("/formapi/selapprover")
    public List<Long> selApprover(@RequestParam("dept_id") Long dept_id);

}
