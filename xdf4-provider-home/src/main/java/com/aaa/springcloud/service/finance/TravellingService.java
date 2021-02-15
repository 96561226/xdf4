package com.aaa.springcloud.service.finance;

import com.aaa.pojo.Emp;
import com.aaa.pojo.EmpVo;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.finance.*;
import com.aaa.pojo.personnel.TbTransfer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Component
@FeignClient(value = "XDF4-PROVIDER-FINANCE",contextId = "travelId")
public interface TravellingService {
    @RequestMapping("/travelling/all")
    public ReturnObj selectTravelingAll(@RequestBody SearchTravelling travelling);

    @GetMapping("/travelling/empAndDept")
    public ReturnObj selectAllEmp();

    @GetMapping("/travelling/content")
    public ReturnObj selectTravellingContents(@RequestParam("id") int id);

    @GetMapping("/travelling/notify")
    public ReturnObj selectTravellingNotifys(@RequestParam("id") int id);

    @PostMapping("/travelling/add")
    public ReturnObj addTravelling(@RequestBody TbTravelling travelling);

    @PostMapping("/travelling/addContent")
    public ReturnObj addContent(@RequestParam("arr[]") String[] arr);

    @GetMapping("/travelling/autoNo")
    public ReturnObj autoNo();

    @PostMapping("/travelling/cancellation")
    public ReturnObj cancellationTravelling(@RequestParam("id") int id);

    @PostMapping("/travelling/cancellations")
    public ReturnObj cancellationTravellings(@RequestParam("ids[]") int[] ids);

    @PostMapping("/travelling/addApprover")
    public ReturnObj addApprover(@RequestParam("arr[]") String[] arr, @RequestParam("no") String no);

    @GetMapping("/travelling/selectSeaEmp")
    public List<EmpVo> selectSeaEmp();
    @PostMapping("/travelling/approve")
    public ReturnObj approve(@RequestBody TbTravelling travelling, @RequestParam("emp_id") Long emp_id);

}
