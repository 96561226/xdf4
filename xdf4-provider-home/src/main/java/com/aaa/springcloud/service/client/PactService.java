package com.aaa.springcloud.service.client;

import com.aaa.pojo.Dept;
import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.client.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@FeignClient(value = "XDF4-PROVIDER-CLIENT",contextId = "pactId")
public interface PactService {
    @RequestMapping("/ps/Pacts")
    public ReturnObj selectAll(@RequestBody SearchPact searchPact);

    @GetMapping("/ps/cnames")
    public ReturnObj cnames();

    @PostMapping("/ps/doAdd")
    public Map<String,String> doAdd(@RequestBody TbPact tbPact);

    @PostMapping("/ps/doAddAfter")
    public Map<String,String> doAddAfter(@RequestBody TbafterSale tbafterSale);

    @PostMapping("/ps/addApprover")
    public ReturnObj addApprover(@RequestParam("arr[]") String[] arr, @RequestParam("no") String no);


    @PostMapping("/ps/doUpdate")
    public ReturnObj doUpdate(@RequestParam("p_id") Integer p_id);
    @GetMapping("/ps/autoNo")
    public ReturnObj autoNo();
    @GetMapping("/ps/Emps")/*初始化穿梭框*/
    public List<Emp> selectAll();
    @PostMapping("/ps/approve")
    public ReturnObj approve(@RequestBody TbPactVo tbPact, @RequestParam("cname") String cname);
}
