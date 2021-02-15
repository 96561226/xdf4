package com.aaa.controller;


import com.aaa.pojo.Emp;
import com.aaa.pojo.EmpVo;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.Roles;
import com.aaa.pojo.personnel.*;
import com.aaa.searchpojo.SearchEmp;
import com.aaa.service.Emp.DeptService;
import com.aaa.service.Emp.EmpService;
import com.aaa.service.Emp.FormService;
import com.aaa.service.Emp.RoleService;
import com.aaa.service.transfer.TransferService;
import com.aaa.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/transfer")
@RestController
public class TransferController extends BaseController {
    @Autowired
    TransferService transferService;
    @Autowired
    FormService formService;
    @Autowired
    EmpService empService;
    @Autowired
    RoleService roleService;
    @Autowired
    DeptService deptService;
    @RequestMapping("/all")
    public ReturnObj selectTransferAll(@RequestBody SearchTransfer transfer){
        System.out.println(transfer);
        ReturnObj obj = transferService.selectTransfer(transfer);
        return obj;
    }
    @PostMapping("/cancellation")
    public ReturnObj cancellationRecruit(@RequestParam("id") int id) {
        TbTransfer transfer  = new TbTransfer();
        transfer.setState(Long.valueOf(4));
        transfer.setTransferId(Long.valueOf(id));
        int i = transferService.updateTransfer(transfer);
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
        int i = transferService.cancellationTransfers(ids);
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
        List<TbTransferType> types = transferService.selectTypeAll();
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
        String s = transferService.selNo("DD-");
        ReturnObj object = new ReturnObj(0,"success",0,s);
        return object;
    }

    @PostMapping("/add")
    public ReturnObj addRecruit(@RequestBody TbTransfer transfer){
        ReturnObj obj;
        int i = transferService.addTransfer(transfer);
        if (i != 0){
            obj = new ReturnObj(0,"success",0,null);
        }else {
            obj = new ReturnObj(400,"error",0,null);
        }
        return obj;
    }

    @PostMapping("/addApprover")
    public ReturnObj addApprover(@RequestParam("arr[]") String[] arr,@RequestParam("no") String no){
        ReturnObj obj;
        int res = 0;
        TbTransfer transfer = new TbTransfer();
        transfer.setTransferNo(no);
        Long transferId = transferService.selectTransferNo(transfer);
        for (int i = 0; i < arr.length; i++) {
            res = transferService.insertTransferApprover(new TbTransferApprover(transferId, Long.valueOf(arr[i])));
        }
        if (res != 0){
            obj = new ReturnObj(0,"success",0,null);
        }else {
            obj = new ReturnObj(200,"error",0,null);
        }
        return obj;
    }

    @GetMapping("/selectEmpById")
    public ReturnObj selectEmpById(@RequestParam("id") int id){
        ReturnObj obj;
        EmpVo emp = transferService.selectEmpById(id);
        if (emp != null){
            obj = new ReturnObj(0,"success",0,emp);
        }else {
            obj = new ReturnObj(400,"err",0,null);
        }
        return obj;
    }
    @GetMapping("/selectRoleById")
    public ReturnObj selectRoleById(@RequestParam("id") int id){
        return roleService.selectRoleById((long)id);
    }
    @PostMapping("/approve")
    public ReturnObj approve(@RequestBody TbTransfer transfer,@RequestParam("emp_id") Long emp_id){
        return transferService.approveTransfer(transfer,emp_id);
    }

}
