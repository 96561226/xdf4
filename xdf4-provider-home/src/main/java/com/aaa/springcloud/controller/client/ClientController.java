package com.aaa.springcloud.controller.client;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.client.SearchClient;
import com.aaa.pojo.client.Tbclient;
import com.aaa.pojo.client.TbclientType;
import com.aaa.springcloud.service.client.ClientService;
import com.aaa.springcloud.util.BaseController;
import org.apache.ibatis.annotations.Param;
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

    @RequestMapping("/Clients")
    public ReturnObj selectAll(SearchClient searchClient){
        return clientService.selectAll(searchClient);
    }

    @GetMapping("/types")
    public List<TbclientType> types(){
        return clientService.types();
    }


    @DeleteMapping("/del")
    public ReturnObj del(Integer c_id){
        return clientService.del(c_id);
    }
    @DeleteMapping("/delAll")
    public ReturnObj delAll(@RequestParam("ids[]") Integer[] ids){
        return clientService.delAll(ids);
    }

    @PostMapping("/doAdd")
    public Map<String,String> doAdd(Tbclient tbclient){
        return clientService.doAdd(tbclient);
    }
    @PutMapping("/doUpdate")
    public Map<String,String> doUpdate(Tbclient tbclient){
        return clientService.doUpdate(tbclient);
    }
}
