package com.aaa.controller;

import com.aaa.pojo.Emp;
import com.aaa.pojo.EmpVo;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.finance.*;
import com.aaa.pojo.personnel.TbDimission;
import com.aaa.searchpojo.SearchEmp;
import com.aaa.service.Emp.DeptService;
import com.aaa.service.Emp.EmpService;
import com.aaa.service.Emp.FormService;
import com.aaa.service.travelling.TravellingService;
import com.aaa.util.BaseController;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/travelling")
@RestController
public class TravellingController extends BaseController {

    @Autowired
    TravellingService travellingService;
    @Autowired
    FormService formService;
    @Autowired
    EmpService empService;
    @Autowired
    DeptService deptService;
    @RequestMapping("/all")
    public ReturnObj selectTravelingAll(@RequestBody SearchTravelling travelling){
        ReturnObj object = travellingService.selectTravelling(travelling);
        return object;
    }

    @GetMapping("/empAndDept")
    public ReturnObj selectAllEmp(){
        List<Emp> emps = empService.selectAll();
        ReturnObj depts = deptService.selDeptAll();
        ReturnObj states = formService.selFormStateAll();
        List list = new ArrayList();
        list.add(emps);
        list.add(depts);
        list.add(states);
        ReturnObj obj  =new ReturnObj(0,"success",0,list);
        return obj;
    }

    @GetMapping("/content")
    public ReturnObj selectTravellingContents(@RequestParam("id") int id){
        ReturnObj obj;
        List<TbTravellingContent> travellingContents = travellingService.selectTravellingContents(id);
        obj = new ReturnObj(0,"success",0,travellingContents);
        return obj;
    }

    @GetMapping("/notify")
    public ReturnObj selectTravellingNotifys(@RequestParam("id") int id){
        ReturnObj obj;
        List<TbTravellingNotifyVo> tbTravellingNotifyVos = travellingService.selectTravellingNotifys(id);
        obj = new ReturnObj(0,"success",0,tbTravellingNotifyVos);
        return obj;
    }

    @PostMapping("/add")
    public ReturnObj addTravelling(@RequestBody TbTravelling travelling){
        ReturnObj obj;
        int i = travellingService.addTravelling(travelling);
        if (i != 0){
            obj = new ReturnObj(200,"success",0,null);
        }else {
            obj = new ReturnObj(0,"error",0,null);
        }
        return obj;
    }

    @PostMapping("/addContent")
    public ReturnObj addContent(@RequestParam("arr[]") String[] arr){
        TbTravelling travelling = new TbTravelling();
        travelling.setTravellingNo(arr[0]);
        Long travellingId = travellingService.selectTravellingByNo(travelling);
            TbTravellingContent content = new TbTravellingContent();
            content.setTravellingId(travellingId);
            content.setStartStopTime(arr[1]);
            content.setStartStopAddress(arr[2]);
            content.setDescription(arr[3]);
            content.setTramp(Double.valueOf(arr[4]));
            content.setCity(Double.valueOf(arr[5]));
            content.setStay(Double.valueOf(arr[6]));
            content.setEvection(Double.valueOf(arr[7]));
            content.setOthers(Double.valueOf(arr[8]));
        int i = travellingService.addContents(content);
        return new ReturnObj(0,"success",0,i);
    }

    @GetMapping("/autoNo")
    public ReturnObj autoNo(){
        String s = travellingService.selTravellingNo();
       ReturnObj object = new ReturnObj(0,"success",0,s);
       return object;
    }

    @PostMapping("/cancellation")
    public ReturnObj cancellationTravelling(@RequestParam("id") int id) {
        TbTravelling travelling = new TbTravelling();
        travelling.setState(Long.valueOf(4));
        travelling.setTravellingId(Long.valueOf(id));
        int i = travellingService.updateTravelling(travelling);
        ReturnObj object;
        if (i != 0){
            object = new ReturnObj(0,"success",0,null);
        }else {
            object = new ReturnObj(400,"error",0,null);
        }
        return object;
    }

    @PostMapping("/cancellations")
    public ReturnObj cancellationTravellings(@RequestParam("ids[]") int[] ids) {
        int i = travellingService.cancellationTravellings(ids);
        ReturnObj object;
        if (i != 0){
            object = new ReturnObj(0,"success",0,null);
        }else {
            object = new ReturnObj(400,"error",0,null);
        }
        return object;
    }

    @PostMapping("/addApprover")
    public ReturnObj addApprover(@RequestParam("arr[]") String[] arr,@RequestParam("no") String no){
        int res = 0;
        TbTravelling travelling = new TbTravelling();
        travelling.setTravellingNo(no);
        Long tavellingId = travellingService.selectTravellingByNo(travelling);
        for (int i = 0; i < arr.length; i++) {
            res = travellingService.addApprover(new TbTravellingApprover(tavellingId, Long.valueOf(arr[i])));
        }
        return new ReturnObj(200,"success",0,res);
    }

    @GetMapping("/selectSeaEmp")
    public List<EmpVo> selectSeaEmp(){
        SearchEmp emp = new SearchEmp();
        List<EmpVo> empVos = empService.selectSeaEmp(emp);
        System.out.println(empVos);
        System.out.println("*********************************************************");
        return empVos;
    }

    @PostMapping("/approve")
    public ReturnObj approve(@RequestBody TbTravelling travelling, @RequestParam("emp_id") Long emp_id){
        return travellingService.approveTravelling(travelling,emp_id);
    }
}
