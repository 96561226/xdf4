package com.aaa.controller;

import com.aaa.pojo.Dept;
import com.aaa.pojo.DeptVo;
import com.aaa.pojo.ReturnObj;
import com.aaa.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ds")
public class DeptController {
    @Autowired
    DeptService deptService;

    @GetMapping("/depts")
    public ReturnObj depts(){
        return deptService.selDeptAll();
    }

    @PostMapping("/insertDept")
    public ReturnObj insertDept(@RequestBody Dept dept) {
        if (null==dept){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        return deptService.insertDept(dept);
    }

    @DeleteMapping("/delDept")
    public ReturnObj delDept(@RequestParam("dept_id") Long dept_id) {
        return deptService.delDept(dept_id);
    }

    @PostMapping("/updDept")
    public ReturnObj updDept(@RequestBody Dept dept) {
        if (null==dept){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        return deptService.updDept(dept);
    }

    @GetMapping("/selDeptById")
    public ReturnObj selDeptById(@RequestParam("dept_id") Long dept_id) {
        return deptService.selDeptById(dept_id);
    }

    @GetMapping("/selDeptVoAll")
    public ReturnObj selDeptVoAll() {
        return deptService.selDeptVoAll();
    }

    @GetMapping("/selDeptVoById")
    public ReturnObj selDeptVoById(@RequestParam("dept_id") Long dept_id) {
        return deptService.selDeptById(dept_id);
    }
}
