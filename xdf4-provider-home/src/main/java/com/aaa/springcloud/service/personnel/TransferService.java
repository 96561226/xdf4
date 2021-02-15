package com.aaa.springcloud.service.personnel;

import com.aaa.pojo.Emp;
import com.aaa.pojo.EmpVo;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.Roles;
import com.aaa.pojo.personnel.*;
import com.aaa.pojo.plans.TbPlan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Component
@FeignClient(value = "XDF4-PROVIDER-PERSONNEL",contextId = "transferId")
public interface TransferService {
    @RequestMapping("/transfer/all")
    public ReturnObj selectTransferAll(@RequestBody SearchTransfer transfer);
    @PostMapping("/transfer/cancellation")
    public ReturnObj cancellationRecruit(@RequestParam("id") int id) ;
    @PostMapping("/transfer/cancellations")
    public ReturnObj cancellationRecruits(@RequestParam("ids[]") int[] ids);

    @GetMapping("/transfer/empRoleAndState")
    public ReturnObj empRoleAndState();

    @GetMapping("/transfer/autoNo")
    public ReturnObj autoNo();

    @PostMapping("/transfer/add")
    public ReturnObj addRecruit(@RequestBody TbTransfer transfer);

    @PostMapping("/transfer/addApprover")
    public ReturnObj addApprover(@RequestParam("arr[]") String[] arr, @RequestParam("no") String no);

    @GetMapping("/transfer/selectEmpById")
    public ReturnObj selectEmpById(@RequestParam("id") int id);
    @GetMapping("/transfer/selectRoleById")
    public ReturnObj selectRoleById(@RequestParam("id") int id);
    @PostMapping("/transfer/approve")
    public ReturnObj approve(@RequestBody TbTransfer transfer, @RequestParam("emp_id") Long emp_id);


}
