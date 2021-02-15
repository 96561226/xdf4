package com.aaa.springcloud.service.api;


import com.aaa.pojo.Dept;
import com.aaa.pojo.ReturnObj;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(value = "XDF4-API-DAO",contextId = "deptId")
public interface DeptService {
    @GetMapping("/ds/depts")
    public ReturnObj depts();

    @PostMapping("/ds/insertDept")
    public ReturnObj insertDept(@RequestBody Dept dept) ;

    @DeleteMapping("/ds/delDept")
    public ReturnObj delDept(@RequestParam("dept_id") Long dept_id) ;

    @PostMapping("/ds/updDept")
    public ReturnObj updDept(@RequestBody Dept dept) ;

    @GetMapping("/ds/selDeptById")
    public ReturnObj selDeptById(@RequestParam("dept_id") Long dept_id) ;

    @GetMapping("/ds/selDeptVoAll")
    public ReturnObj selDeptVoAll();

    @GetMapping("/ds/selDeptVoById")
    public ReturnObj selDeptVoById(@RequestParam("dept_id") Long dept_id) ;
}
