package com.aaa.springcloud.service.client;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.client.SearchClient;
import com.aaa.pojo.client.Tbclient;
import com.aaa.pojo.client.TbclientType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@FeignClient(value = "XDF4-PROVIDER-CLIENT",contextId = "clientId")
public interface ClientService {
    @RequestMapping("/cs/Clients")
    public ReturnObj selectAll(@RequestBody SearchClient searchClient);

    @GetMapping("/cs/types")
    public List<TbclientType> types();


    @DeleteMapping("/cs/del")
    public ReturnObj del(@RequestParam("c_id") Integer c_id);

    @DeleteMapping("/cs/delAll")
    public ReturnObj delAll(@RequestParam("ids[]") Integer[] ids);

    @PostMapping("/cs/doAdd")
    public Map<String,String> doAdd(@RequestBody Tbclient tbclient);
    @PutMapping("/cs/doUpdate")
    public Map<String,String> doUpdate(@RequestBody Tbclient tbclient);
}
