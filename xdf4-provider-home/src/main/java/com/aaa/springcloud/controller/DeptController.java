package com.aaa.springcloud.controller;

import com.aaa.pojo.Dept;
import com.aaa.pojo.ReturnObj;
import com.aaa.springcloud.service.api.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ds")
public class DeptController {
    @Autowired
    DeptService deptService;

    @GetMapping("/depts")
    public ReturnObj depts(){
        return deptService.depts();
    }

    @PostMapping("/insertDept")
    public ReturnObj insertDept(Dept dept) {
        if (null==dept){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        return deptService.insertDept(dept);
    }

    @DeleteMapping("/delDept")
    public ReturnObj delDept(Long dept_id) {
        return deptService.delDept(dept_id);
    }

    @PostMapping("/updDept")
    public ReturnObj updDept(Dept dept) {
        if (null==dept){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        System.out.println(dept);
        return deptService.updDept(dept);
    }

    @GetMapping("/selDeptById")
    public ReturnObj selDeptById(Long dept_id) {
        return deptService.selDeptById(dept_id);
    }

    @GetMapping("/selDeptVoAll")
    public ReturnObj selDeptVoAll() {
        return deptService.selDeptVoAll();
    }

    @GetMapping("/selDeptVoById")
    public ReturnObj selDeptVoById(Long dept_id) {
        return deptService.selDeptById(dept_id);
    }
}
