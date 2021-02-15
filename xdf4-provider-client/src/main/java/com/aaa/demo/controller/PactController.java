package com.aaa.demo.controller;

import com.aaa.demo.service.*;
import com.aaa.demo.util.BaseController;
import com.aaa.pojo.Dept;
import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.client.*;
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
    @Autowired
    ClientService clientService;
    @Autowired
    EmpService empService;
    @Autowired
    DeptService deptService;
    @Autowired
    AfterTypeService afterTypeService;

    @RequestMapping("/Pacts")
    public ReturnObj selectAll(@RequestBody SearchPact searchPact){
        ReturnObj obj =  pactService.selectAll(searchPact);
        return obj;
    }

    @GetMapping("/cnames")
    public ReturnObj cnames(){
        List<Tbclient> cnames = clientService.selectCname();
        List<TbPactState> states = pactService.selState();
        List<Emp> emps = empService.selectAll();
        List<Dept> depts = deptService.selectAll();
        List<TbafterType> types = afterTypeService.selectAll();
        List list =new ArrayList();
        list.add(cnames);
        list.add(states);
        list.add(emps);
        list.add(depts);
        list.add(types);
        ReturnObj obj=new ReturnObj(0,"success",0,list);
        return obj;
    }

    @PostMapping("/doAdd")
    public Map<String,String> doAdd(@RequestBody TbPact tbPact){
        int result = pactService.insert(tbPact);
        Map<String,String> map = new HashMap<>();
        if(result>0){
            map.put("result","success");
        }else{
            map.put("result","error");
        }
        return map;
    }

    @PostMapping("/doAddAfter")
    public Map<String,String> doAddAfter(@RequestBody TbafterSale tbafterSale){
        int result = pactService.insertAfter(tbafterSale);
        Map<String,String> map = new HashMap<>();
        if(result>0){
            map.put("result","success");
        }else{
            map.put("result","error");
        }
        return map;
    }

    @PostMapping("/addApprover")
    public ReturnObj addApprover(@RequestParam("arr[]") String[] arr, @RequestParam("no") String no){
        ReturnObj obj;
        int res = 0;
        Integer p_id = pactService.selectEntryNo(no);
        for (int i = 0; i < arr.length; i++) {
           res= pactService.insertPactApprover(new TbPactApprover(p_id, Integer.valueOf(arr[i])));
        }
        if (res != 0){
            obj = new ReturnObj(0,"success",0,null);
        }else {
            obj = new ReturnObj(200,"error",0,null);
        }
        return obj;
    }

    @PostMapping("/doUpdate")
    public ReturnObj doUpdate(@RequestParam("p_id") Integer p_id){
        ReturnObj obj;
        int res = pactService.update(p_id);
        if (res != 0){
            obj = new ReturnObj(0,"success",0,null);
        }else {
            obj = new ReturnObj(200,"error",0,null);
        }
        return obj;
    }
    @GetMapping("/autoNo")
    public ReturnObj autoNo(){
        String s = pactService.selNo();
        ReturnObj object = new ReturnObj(0,"success",0,s);
        return object;
    }
    @GetMapping("/Emps")/*初始化穿梭框*/
    public List<Emp> selectAll(){
        List<Emp> emps = empService.selectAll();
        return emps;
    }

    @PostMapping("/approve")
    public ReturnObj approve(@RequestBody TbPactVo tbPact,@RequestParam("cname") String cname){
        ReturnObj obj;
        int i = pactService.updatePactState(tbPact,cname);
        if (i != 0){
            obj = new ReturnObj(0,"success",i,i);
        }else {
            obj = new ReturnObj(400,"error",i,i);
        }
        return obj;
    }

}
