package com.aaa.springcloud.service.personnel;

import com.aaa.pojo.Emp;
import com.aaa.pojo.EmpVo;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.Roles;
import com.aaa.pojo.personnel.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Component
@FeignClient(value = "XDF4-PROVIDER-PERSONNEL",contextId = "dimissionId")
public interface DimissionService {
    @RequestMapping("/dimission/all")
    public ReturnObj selectEntryAll(@RequestBody SearchDimission dimission);
    @PostMapping("/dimission/cancellation")
    public ReturnObj cancellationDimission(@RequestParam("id") int id) ;
    @PostMapping("/dimission/cancellations")
    public ReturnObj cancellationRecruits(@RequestParam("ids[]") int[] ids) ;

    @GetMapping("/dimission/empRoleAndState")
    public ReturnObj empRoleAndState();

    @GetMapping("/dimission/autoNo")
    public ReturnObj autoNo();

    @PostMapping("/dimission/add")
    public ReturnObj addRecruit(@RequestBody TbDimission dimission);

    @PostMapping("/dimission/addApprover")
    public ReturnObj addApprover(@RequestParam("arr[]") String[] arr, @RequestParam("no") String no);



    @PostMapping("/dimission/approve")
    public ReturnObj approve(@RequestBody TbDimission dimission, @RequestParam("emp_id") Long emp_id);

}
