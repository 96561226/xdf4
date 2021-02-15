package com.aaa.springcloud.controller.finance;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class FinanceNavController {
    @RequestMapping("/finance/travellingIndex")
    public String toTravelling(){
        return "finance/travelling/travellingIndex";
    }
    @RequestMapping("/finance/incomeIndex")
    public String toIncome(){
        return "finance/income/income_index";
    }
}
