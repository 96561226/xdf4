package com.aaa.springcloud.controller.personnel;


import com.aaa.pojo.Emp;
import com.aaa.pojo.EmpVo;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.Roles;
import com.aaa.pojo.personnel.*;
import com.aaa.springcloud.service.api.EmpService;
import com.aaa.springcloud.service.personnel.TransferService;
import com.aaa.springcloud.util.BaseController;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/transfer")
@RestController
public class TransferController extends BaseController {
    @Autowired
    TransferService transferService;
    @Autowired
    EmpService empService;
    @RequestMapping("/all")
    public ReturnObj selectTransferAll(SearchTransfer transfer){
        return transferService.selectTransferAll(transfer);
    }
    @PostMapping("/cancellation")
    public ReturnObj cancellationRecruit(int id) {
        return transferService.cancellationRecruit(id);
    }
    @PostMapping("/cancellations")
    public ReturnObj cancellationRecruits(@RequestParam("ids[]") int[] ids) {
        return transferService.cancellationRecruits(ids);
    }

    @GetMapping("/empRoleAndState")
    public ReturnObj empRoleAndState(){
        return transferService.empRoleAndState();
    }

    @GetMapping("/autoNo")
    public ReturnObj autoNo(){
        return transferService.autoNo();
    }

    @PostMapping("/add")
    public ReturnObj addRecruit(TbTransfer transfer){
        return transferService.addRecruit(transfer);
    }

    @PostMapping("/addApprover")
    public ReturnObj addApprover(String[] arr,String no){
        return transferService.addApprover(arr,no);
    }


    @GetMapping("/selectEmpById")
    public ReturnObj selectEmpById(int id){
        return transferService.selectEmpById(id);
    }

    @GetMapping("/selectRoleById")
    public ReturnObj selectRoleById(int id){
        return transferService.selectRoleById(id);
    }

    //审批
    @PostMapping("/approve")
    public ReturnObj approve(TbTransfer transfer){
        Authentication au = SecurityContextHolder.getContext().getAuthentication();
        Object[] array = au.getAuthorities().toArray();

        Long emp_id = Long.valueOf(array[0].toString()) ;
        String emp_no = array[1].toString();

        Emp emp = empService.selectByNo(emp_no);
        if (null==emp || null==emp.getEmp_id()){
            return new ReturnObj(400,"非法操作",null,null);
        }
        return transferService.approve(transfer,emp_id);
    }
}
