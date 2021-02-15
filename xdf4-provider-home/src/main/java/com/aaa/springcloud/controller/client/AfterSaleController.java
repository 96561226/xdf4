package com.aaa.springcloud.controller.client;

import com.aaa.pojo.Dept;
import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.client.SearchAfter;
import com.aaa.pojo.client.TbAfterState;
import com.aaa.pojo.client.TbafterType;
import com.aaa.pojo.client.Tbclient;
import com.aaa.springcloud.service.client.AfterSaleService;
import com.aaa.springcloud.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/as")
public class AfterSaleController  extends BaseController {
    @Autowired
    AfterSaleService afterSaleService;
    @RequestMapping("/AfterSales")
    public ReturnObj selectAll(SearchAfter searchAfter){
        return afterSaleService.selectAll(searchAfter);
    }
    @GetMapping("/types")
    public ReturnObj types(){
        return afterSaleService.types();
    }
    @PostMapping("/doUpdate")
    public ReturnObj doUpdate(Integer s_id){
        return afterSaleService.doUpdate(s_id);
    }

}
