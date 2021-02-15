package com.aaa.springcloud.service.personnel;

import com.aaa.pojo.Emp;
import com.aaa.pojo.EmpVo;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.Roles;
import com.aaa.pojo.personnel.SearchEntry;
import com.aaa.pojo.personnel.TbEntry;
import com.aaa.pojo.personnel.TbEntryApprover;
import com.aaa.pojo.personnel.TbTransfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Component
@FeignClient(value = "XDF4-PROVIDER-PERSONNEL",contextId = "entryId")
public interface EntryService {
    @RequestMapping("/entry/all")
    public ReturnObj selectEntryAll(@RequestBody SearchEntry entry);
    @PostMapping("/entry/cancellation")
    public ReturnObj cancellationRecruit(@RequestParam("id") int id);
    @PostMapping("/entry/cancellations")
    public ReturnObj cancellationRecruits(@RequestParam("ids[]") int[] ids);

    @GetMapping("/entry/empRoleAndState")
    public ReturnObj empRoleAndState();

    @GetMapping("/entry/autoNo")
    public ReturnObj autoNo();

    @PostMapping("/entry/add")
    public ReturnObj addRecruit(@RequestBody TbEntry entry);

    @PostMapping("/entry/addApprover")
    public ReturnObj addApprover(@RequestParam("arr[]") String[] arr, @RequestParam("no") String no);


    @PostMapping("/entry/approve")
    public ReturnObj approve(@RequestBody TbEntry entry, @RequestParam("emp_id") Long emp_id);

}
