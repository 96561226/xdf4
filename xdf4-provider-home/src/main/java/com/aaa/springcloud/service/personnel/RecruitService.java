package com.aaa.springcloud.service.personnel;

import com.aaa.pojo.Emp;
import com.aaa.pojo.EmpVo;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.Roles;
import com.aaa.pojo.personnel.SearchRecruit;
import com.aaa.pojo.personnel.TbRecruit;
import com.aaa.pojo.personnel.TbRecruitApprover;
import com.aaa.pojo.personnel.TbTransfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Component
@FeignClient(value = "XDF4-PROVIDER-PERSONNEL",contextId = "recruitId")
public interface RecruitService {
    @RequestMapping("/recruit/all")
    public ReturnObj selectRecruitAll(@RequestBody SearchRecruit recruit);
    @PostMapping("/recruit/cancellation")
    public ReturnObj cancellationRecruit(@RequestParam("id") int id);
    @PostMapping("/recruit/cancellations")
    public ReturnObj cancellationRecruits(@RequestParam("ids[]") int[] ids);
    @GetMapping("/recruit/empRoleAndState")
    public ReturnObj empRoleAndState();
    @GetMapping("/recruit/autoNo")
    public ReturnObj autoNo();

    @PostMapping("/recruit/add")
    public ReturnObj addRecruit(@RequestBody TbRecruit recruit);
    @PostMapping("/recruit/addApprover")
    public ReturnObj addApprover(@RequestParam("arr[]") String[] arr, @RequestParam("no") String no);

    @GetMapping("/recruit/selectSeaEmp")
    public List<EmpVo> selectSeaEmp();


    @PostMapping("/recruit/approve")
    public ReturnObj approve(@RequestBody TbRecruit recruit, @RequestParam("emp_id") Long emp_id);

}
