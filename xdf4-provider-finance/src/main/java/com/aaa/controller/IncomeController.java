package com.aaa.controller;

import com.aaa.mapper.travelling.TravellingContentMapper;
import com.aaa.pojo.*;
import com.aaa.pojo.finance.SearchIncome;
import com.aaa.pojo.finance.TbGathering;
import com.aaa.pojo.finance.TbIncome;
import com.aaa.pojo.finance.TbPaymentType;
import com.aaa.service.Emp.DeptService;
import com.aaa.service.Emp.EmpService;
import com.aaa.service.Emp.FormService;
import com.aaa.service.income.IncomeService;
import com.aaa.service.travelling.TravellingService;
import com.aaa.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/income")
@RestController
public class IncomeController extends BaseController {

    @Autowired
    TravellingService travellingService;
    @Autowired
    TravellingContentMapper travellingContentMapper;
    @Autowired
    FormService formService;
    @Autowired
    EmpService empService;
    @Autowired
    DeptService deptService;
    @Autowired
    IncomeService incomeService;
    @RequestMapping("/all")
    public ReturnObj selectTravelingAll(@RequestBody SearchIncome income){
        System.out.println(income.getState());
        ReturnObj object = incomeService.selectIncome(income);
        return object;
    }
    @GetMapping("/empAndDept")
    public ReturnObj selectAllEmp(){
        List<Emp> emps = empService.selectAll();
        ReturnObj depts = deptService.selDeptAll();
        List<TbPaymentType> tbPaymentTypes = incomeService.selectAllPaymentType();
        List<TbGathering> tbGatherings = incomeService.selectAllGathering();
        List list = new ArrayList();
        list.add(emps);
        list.add(depts);
        list.add(tbPaymentTypes);
        list.add(tbGatherings);
        ReturnObj obj  =new ReturnObj(0,"success",0,list);
        return obj;
    }

    @PostMapping("/addIncome")
    public ReturnObj addIncome(@RequestBody TbIncome income){
        return incomeService.addIncome(income);
    }


}
