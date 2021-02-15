package com.aaa.springcloud.controller.client;

import com.aaa.pojo.Dept;
import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.client.*;
import com.aaa.springcloud.service.client.ClientService;
import com.aaa.springcloud.service.client.PactService;
import com.aaa.springcloud.util.BaseController;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ps")
public class PactController extends BaseController {
    @Autowired
    PactService pactService;

    @RequestMapping("/Pacts")
    public ReturnObj selectAll(SearchPact searchPact){
        return pactService.selectAll(searchPact);
    }

    @GetMapping("/cnames")
    public ReturnObj cnames(){
        return pactService.cnames();
    }

    @PostMapping("/doAdd")
    public Map<String,String> doAdd(TbPact tbPact){
        return pactService.doAdd(tbPact);
    }

    @PostMapping("/doAddAfter")
    public Map<String,String> doAddAfter(TbafterSale tbafterSale){
        return pactService.doAddAfter(tbafterSale);
    }

    @PostMapping("/addApprover")
    public ReturnObj addApprover(String[] arr,String no){
        return pactService.addApprover(arr,no);
    }

    @PostMapping("/doUpdate")
    public ReturnObj doUpdate(Integer p_id){
        return pactService.doUpdate(p_id);
    }
    @GetMapping("/autoNo")
    public ReturnObj autoNo(){
        return pactService.autoNo();
    }
    @GetMapping("/Emps")/*初始化穿梭框*/
    public List<Emp> selectAll(){
        return pactService.selectAll();
    }

    @PostMapping("/approve")
    public ReturnObj approve(TbPactVo tbPact,String cname){
        System.out.println(tbPact);
        System.out.println("***************************************");
        return pactService.approve(tbPact,cname);
    }
}
