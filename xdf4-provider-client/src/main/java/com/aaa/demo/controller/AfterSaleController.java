package com.aaa.demo.controller;

import com.aaa.demo.service.*;
import com.aaa.demo.util.BaseController;
import com.aaa.pojo.Dept;
import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.client.SearchAfter;
import com.aaa.pojo.client.TbAfterState;
import com.aaa.pojo.client.TbafterType;
import com.aaa.pojo.client.Tbclient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/as")
public class AfterSaleController  extends BaseController {
    @Autowired
    AfterSaleService afterSaleService;
    @Autowired
    ClientService clientService;
    @Autowired
    EmpService empService;
    @Autowired
    DeptService deptService;
    @Autowired
    AfterTypeService afterTypeService;
    @RequestMapping("/AfterSales")
    public ReturnObj selectAll(@RequestBody SearchAfter searchAfter){
        ReturnObj obj =  afterSaleService.selectAll(searchAfter);
        return obj;
    }
    @GetMapping("/types")
    public ReturnObj types(){
        List<TbafterType> types = afterTypeService.selectAll();
        List<Tbclient> cnames = clientService.selectCname();
        List<Emp> emps = empService.selectAll();
        List<Dept> depts = deptService.selectAll();
        List<TbAfterState> states = afterSaleService.selState();
        List list =new ArrayList();
        list.add(cnames);
        list.add(types);
        list.add(emps);
        list.add(depts);
        list.add(states);
        ReturnObj obj=new ReturnObj(0,"success",0,list);
        return obj;
    }
    @PostMapping("/doUpdate")
    public ReturnObj doUpdate(@RequestParam("s_id") Integer s_id){
        ReturnObj obj;
        int res = afterSaleService.update(s_id);
        if (res != 0){
            obj = new ReturnObj(0,"success",0,null);
        }else {
            obj = new ReturnObj(200,"error",0,null);
        }
        return obj;
    }

}
