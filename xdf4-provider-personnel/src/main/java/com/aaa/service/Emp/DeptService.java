package com.aaa.service.Emp;


import com.aaa.pojo.Dept;
import com.aaa.pojo.ReturnObj;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "XDF4-API-DAO",contextId = "deptId")
public interface DeptService {
    @GetMapping("/ds/depts")
    ReturnObj selDeptAll();
}
