package com.aaa.demo.controller;

import com.aaa.demo.service.ClientService;
import com.aaa.demo.service.ClientTypeService;
import com.aaa.demo.util.BaseController;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.client.SearchClient;
import com.aaa.pojo.client.Tbclient;
import com.aaa.pojo.client.TbclientType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cs")
public class ClientController  extends BaseController {
    @Autowired
    ClientService clientService;
    @Autowired
    ClientTypeService clientTypeService;
    @RequestMapping("/Clients")
    public ReturnObj selectAll(@RequestBody SearchClient searchClient){
        ReturnObj obj =  clientService.selectAll(searchClient);
        return obj;
    }

    @GetMapping("/types")
    public List<TbclientType> types(){
        List<TbclientType> types = clientTypeService.selectAll();
        return types;
    }


    @DeleteMapping("/del")
    public ReturnObj del(@RequestParam("c_id") Integer c_id){
        clientService.del(c_id);
        return new ReturnObj(0,"",0,"success");
    }
    @DeleteMapping("/delAll")
    public ReturnObj delAll(@RequestParam("ids[]") Integer[] ids){
        clientService.delAll(ids);
        return new ReturnObj(0,"",0,"success");
    }

    @PostMapping("/doAdd")
    public Map<String,String> doAdd(@RequestBody Tbclient tbclient){
        int result = clientService.insert(tbclient);
        Map<String,String> map = new HashMap<>();
        if(result>0){
            map.put("result","success");
        }else{
            map.put("result","error");
        }
        return map;
    }
    @PostMapping("/doUpdate")
    public Map<String,String> doUpdate(@RequestParam Tbclient tbclient){
        int result = clientService.update(tbclient);
        Map<String,String> map = new HashMap<>();
        if(result>0){
            map.put("result","success");
        }else{
            map.put("result","error");
        }
        return map;
    }
}
