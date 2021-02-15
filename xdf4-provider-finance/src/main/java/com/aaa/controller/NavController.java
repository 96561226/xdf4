package com.aaa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/finance")
public class NavController {

    @RequestMapping("/travellingIndex")
    public String toTravelling(){
        return "/travelling/travellingIndex";
    }
    @RequestMapping("/incomeIndex")
    public String toIncome(){
        return "/income/income_index";
    }

}
