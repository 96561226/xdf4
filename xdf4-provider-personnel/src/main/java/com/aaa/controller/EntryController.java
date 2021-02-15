package com.aaa.controller;


import com.aaa.pojo.*;
import com.aaa.pojo.personnel.SearchEntry;
import com.aaa.pojo.personnel.TbEntry;
import com.aaa.pojo.personnel.TbEntryApprover;
import com.aaa.pojo.personnel.TbTransfer;
import com.aaa.searchpojo.SearchEmp;
import com.aaa.service.Emp.DeptService;
import com.aaa.service.Emp.EmpService;
import com.aaa.service.Emp.FormService;
import com.aaa.service.Emp.RoleService;
import com.aaa.service.entry.EntryService;
import com.aaa.util.BaseController;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/entry")
@RestController
public class EntryController extends BaseController {
    @Autowired
    EntryService entryService;
    @Autowired
    FormService formService;
    @Autowired
    EmpService empService;
    @Autowired
    RoleService roleService;
    @Autowired
    DeptService deptService;
    @RequestMapping("/all")
    public ReturnObj selectEntryAll(@RequestBody SearchEntry entry){
        ReturnObj obj = entryService.selectEntry(entry);
        System.out.println(obj);
        return obj;
    }
    @PostMapping("/cancellation")
    public ReturnObj cancellationRecruit(@RequestParam("id") int id) {
        TbEntry entry = new TbEntry();
        entry.setState(Long.valueOf(4));
        entry.setEntryId(Long.valueOf(id));
        int i = entryService.updateEntry(entry);
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
        int i = entryService.cancellationEntrys(ids);
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
        List list = new ArrayList();
        list.add(emps);
        list.add(states);
        list.add(roles);
        list.add(depts);
        ReturnObj obj  =new ReturnObj(0,"success",0,list);
        return obj;
    }

    @GetMapping("/autoNo")
    public ReturnObj autoNo(){
        String s = entryService.selNo("RZ-");
        ReturnObj object = new ReturnObj(0,"success",0,s);
        return object;
    }

    @PostMapping("/add")
    public ReturnObj addRecruit(@RequestBody TbEntry entry){
        ReturnObj obj;
        int i = entryService.addEntry(entry);
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
        TbEntry entry = new TbEntry();
        entry.setEntryNo(no);
        Long entryId = entryService.selectEntryNo(entry);
        for (int i = 0; i < arr.length; i++) {
            res = entryService.insertEntryApprover(new TbEntryApprover(entryId, Long.valueOf(arr[i])));
        }
        if (res != 0){
            obj = new ReturnObj(0,"success",0,null);
        }else {
            obj = new ReturnObj(200,"error",0,null);
        }
        return obj;
    }


    @PostMapping("/approve")
    public ReturnObj approve(@RequestBody TbEntry entry, @RequestParam("emp_id") Long emp_id){
        return entryService.approveEntry(entry,emp_id);
    }
}
