package com.aaa.springcloud.controller.finance;

import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.finance.SearchIncome;
import com.aaa.pojo.finance.TbGathering;
import com.aaa.pojo.finance.TbPaymentType;
import com.aaa.springcloud.service.finance.IncomeService;
import com.aaa.springcloud.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/income")
@RestController
public class IncomeController extends BaseController {

    @Autowired
    IncomeService incomeService;
    @RequestMapping("/all")
    public ReturnObj selectTravelingAll(SearchIncome income){
        return incomeService.selectTravelingAll(income);
    }
    @GetMapping("/empAndDept")
    public ReturnObj selectAllEmp(){
        return incomeService.selectAllEmp();
    }


}
