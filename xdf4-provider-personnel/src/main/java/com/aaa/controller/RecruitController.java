package com.aaa.controller;


import com.aaa.pojo.*;
import com.aaa.pojo.personnel.SearchRecruit;
import com.aaa.pojo.personnel.TbDimission;
import com.aaa.pojo.personnel.TbRecruit;
import com.aaa.pojo.personnel.TbRecruitApprover;
import com.aaa.searchpojo.SearchEmp;
import com.aaa.service.Emp.EmpService;
import com.aaa.service.Emp.FormService;
import com.aaa.service.Emp.RoleService;
import com.aaa.service.recruit.RecruitService;
import com.aaa.util.BaseController;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RequestMapping("/recruit")
@RestController
public class RecruitController extends BaseController {

    @Autowired
    RecruitService recruitService;
    @Autowired
    FormService formService;
    @Autowired
    EmpService empService;
    @Autowired
    RoleService roleService;
    @RequestMapping("/all")
    public ReturnObj selectRecruitAll(@RequestBody SearchRecruit recruit){
        return recruitService.selectRecruit(recruit);
    }
    @PostMapping("/cancellation")
    public ReturnObj cancellationRecruit(@RequestParam("id") int id) {
        TbRecruit recruit = new TbRecruit();
        recruit.setState(Long.valueOf(4));
        recruit.setRecruitId(Long.valueOf(id));
        int i = recruitService.updateRecruit(recruit);
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
        int i = recruitService.cancellationRecruits(ids);
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
        ReturnObj roles = roleService.selectRoles();
        List list = new ArrayList();
        list.add(emps);
        list.add(states);
        list.add(roles);
        ReturnObj obj  =new ReturnObj(0,"success",0,list);
        return obj;
    }
    @GetMapping("/autoNo")
    public ReturnObj autoNo(){
        String s = recruitService.selNo("ZP-");
        ReturnObj object = new ReturnObj(0,"success",0,s);
        return object;
    }

    @PostMapping("/add")
    public ReturnObj addRecruit(@RequestBody TbRecruit recruit){
        ReturnObj obj;
        int i = recruitService.addRecruit(recruit);
        if (i != 0){
            obj = new ReturnObj(0,"success",0,null);
        }else {
            obj = new ReturnObj(200,"error",0,null);
        }
        return obj;
    }
    @PostMapping("/addApprover")
    public ReturnObj addApprover(@RequestParam("arr[]") String[] arr, @RequestParam("no") String no){
        ReturnObj obj;
        int res = 0;
        TbRecruit recruit = new TbRecruit();
        recruit.setRecruitNo(no);
        Long recruitId = recruitService.selectRecruitNo(recruit);
        for (int i = 0; i < arr.length; i++) {
            res = recruitService.insertRecruitApprover(new TbRecruitApprover(recruitId, Long.valueOf(arr[i])));
        }
        if (res != 0){
            obj = new ReturnObj(0,"success",0,null);
        }else {
            obj = new ReturnObj(200,"error",0,null);
        }
        return obj;
    }

    @GetMapping("/selectSeaEmp")
    public List<EmpVo> selectSeaEmp(){
        SearchEmp emp = new SearchEmp();
        List<EmpVo> empVos = empService.selectSeaEmp(emp);
        return empVos;
    }
    @PostMapping("/approve")
    public ReturnObj approve(@RequestBody TbRecruit recruit, @RequestParam("emp_id") Long emp_id){
        return recruitService.approveRecruit(recruit,emp_id);
    }
}
