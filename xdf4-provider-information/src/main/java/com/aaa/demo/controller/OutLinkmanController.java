package com.aaa.demo.controller;

import com.aaa.demo.service.*;
import com.aaa.demo.util.BaseController;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.informaction.SearchOutlinkman;
import com.aaa.pojo.informaction.Tboutlinkman;
import com.aaa.pojo.informaction.TboutlinkmanType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/outlinks")
public class OutLinkmanController extends BaseController {
    @Autowired
    OutLinkmanService outLinkmanService;
    @Autowired
    OutTypeService outTypeService;
    @RequestMapping("/Outlinks")
    public ReturnObj selectAll(@RequestBody SearchOutlinkman outlinkman){
        ReturnObj obj =  outLinkmanService.selectAll(outlinkman);
        return obj;
    }

    @GetMapping("/types")
    public List<TboutlinkmanType> types(){
        List<TboutlinkmanType> types = outTypeService.selectAll();
        return types;
    }


    @DeleteMapping("/del")
    public ReturnObj del(@RequestParam("id") Integer id){
        outLinkmanService.del(id);
        return new ReturnObj(0,"",0,"success");
    }
    @DeleteMapping("/delAll")
    public ReturnObj delAll(@RequestParam("ids[]") Integer[] ids){
        outLinkmanService.delAll(ids);
        return new ReturnObj(0,"",0,"success");
    }

    @PostMapping("/doAdd")
    public Map<String,String> doAdd(@RequestBody Tboutlinkman tboutlinkman){
        int result = outLinkmanService.insert(tboutlinkman);
        Map<String,String> map = new HashMap<>();
        if(result>0){
            map.put("result","success");
        }else{
            map.put("result","error");
        }
        return map;
    }
    @PostMapping("/doUpdate")
    public Map<String,String> doUpdate(@RequestBody Tboutlinkman tboutlinkman){
        int result = outLinkmanService.update(tboutlinkman);
        Map<String,String> map = new HashMap<>();
        if(result>0){
            map.put("result","success");
        }else{
            map.put("result","error");
        }
        return map;
    }
}
