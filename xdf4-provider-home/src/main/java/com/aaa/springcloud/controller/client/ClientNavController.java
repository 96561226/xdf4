package com.aaa.springcloud.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ClientNavController {
    //客户信息
    @RequestMapping("/client/clientIndex")
    public String toClientIndex(){
        return "client/Client/index";
    }
    @RequestMapping("/client/pactIndex")
    public String toPactIndex(){
        return "client/Pact/index";
    }
    @RequestMapping("/client/mypactIndex")
    public String tomypactIndex(){
        return "client/Pact/mypact";
    }
    @RequestMapping("/client/aftersaleIndex")
    public String toAfterSaleIndex(){
        return "client/AfterSale/index";
    }
}
