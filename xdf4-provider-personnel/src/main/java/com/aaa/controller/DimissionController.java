package com.aaa.controller;


import com.aaa.pojo.*;
import com.aaa.pojo.personnel.*;
import com.aaa.searchpojo.SearchEmp;
import com.aaa.service.Emp.DeptService;
import com.aaa.service.Emp.EmpService;
import com.aaa.service.Emp.FormService;
import com.aaa.service.Emp.RoleService;
import com.aaa.service.dimission.DimissionService;
import com.aaa.util.BaseController;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/dimission")
@RestController
public class DimissionController extends BaseController {
    @Autowired
    DimissionService dimissionService;
    @Autowired
    FormService formService;
    @Autowired
    EmpService empService;
    @Autowired
    RoleService roleService;
    @Autowired
    DeptService deptService;
    @RequestMapping("/all")
    public ReturnObj selectEntryAll(@RequestBody SearchDimission dimission){
        return dimissionService.selectDimission(dimission);
    }
    @PostMapping("/cancellation")
    public ReturnObj cancellationRecruit(@RequestParam("id") int id) {
        TbDimission dimission = new TbDimission();
        dimission.setState(Long.valueOf(4));
        dimission.setDimissionId(Long.valueOf(id));
        int i = dimissionService.updateDimission(dimission);
        ReturnObj object;
        if (i != 0){
            object = new ReturnObj(0,"success",0,null);
        }else {
            object = new ReturnObj(400,"error",0,null);
        }
        return object;
    }
    @PostMapping("/cancellations")
    public ReturnObj cancellationRecruits(@RequestParam("ids[]") int[] ids) {
        int i = dimissionService.cancellationDimissions(ids);
        ReturnObj object;
        if (i != 0){
            object = new ReturnObj(0,"success",0,null);
        }else {
            object = new ReturnObj(400,"error",0,null);
        }
        return object;
    }

    @GetMapping("/empRoleAndState")
    public ReturnObj empRoleAndState(){
        List<EmpVo> emps = empService.selectSeaEmp(new SearchEmp());
        ReturnObj states = formService.selFormStateAll();
        ReturnObj depts = deptService.selDeptAll();
        ReturnObj roles = roleService.selectRoles();
        List<TbDimissionType> types = dimissionService.selectDimissionTypeAll();
        List list = new ArrayList();
        list.add(emps);
        list.add(states);
        list.add(roles);
        list.add(depts);
        list.add(types);
        ReturnObj obj  =new ReturnObj(0,"success",0,list);
        return obj;
    }

    @GetMapping("/autoNo")
    public ReturnObj autoNo(){
        String s = dimissionService.selDimissionNo("LZ-");
        ReturnObj object = new ReturnObj(0,"success",0,s);
        return object;
    }

    @PostMapping("/add")
    public ReturnObj addRecruit(@RequestBody TbDimission dimission){
        ReturnObj obj;
        int i = dimissionService.addDimission(dimission);
        if (i != 0){
            obj = new ReturnObj(0,"success",0,null);
        }else {
            obj = new ReturnObj(200,"error",0,null);
        }
        return obj;
    }

    @PostMapping("/addApprover")
    public ReturnObj addApprover(@RequestParam("arr[]") String[] arr,@RequestParam("no") String no){
        ReturnObj obj;
        int res = 0;
        TbDimission dimission = new TbDimission();
        dimission.setDimissionNo(no);
        Long dimissionId = dimissionService.selectDimissionNo(dimission);
        for (int i = 0; i < arr.length; i++) {
            res = dimissionService.insertDimissionApprover(new TbDimissionApprover(dimissionId, Long.valueOf(arr[i])));
        }
        if (res != 0){
            obj = new ReturnObj(0,"success",0,null);
        }else {
            obj = new ReturnObj(400,"error",0,null);
        }
        return obj;
    }

    @PostMapping("/approve")
    public ReturnObj approve(@RequestBody TbDimission dimission, @RequestParam("emp_id") Long emp_id){
        return dimissionService.approveDimission(dimission,emp_id);
    }
}
