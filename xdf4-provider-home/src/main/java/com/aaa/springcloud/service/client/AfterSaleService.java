package com.aaa.springcloud.service.client;

import com.aaa.pojo.Dept;
import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.client.SearchAfter;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Component
@FeignClient(value = "XDF4-PROVIDER-CLIENT",contextId = "afterSaleId")
public interface AfterSaleService {
    @RequestMapping("/as/AfterSales")
    public ReturnObj selectAll(@RequestBody SearchAfter searchAfter);
    @GetMapping("/as/types")
    public ReturnObj types();
    @PostMapping("/as/doUpdate")
    public ReturnObj doUpdate(@RequestParam("s_id") Integer s_id);
}
