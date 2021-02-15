package com.aaa.springcloud.controller.informaction;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.informaction.SearchOutlinkman;
import com.aaa.pojo.informaction.Tboutlinkman;
import com.aaa.pojo.informaction.TboutlinkmanType;
import com.aaa.springcloud.service.informaction.OutLinkmanService;
import com.aaa.springcloud.util.BaseController;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/outlinks")
public class OutLinkmanController extends BaseController {
    @Autowired
    OutLinkmanService outLinkmanService;

    @RequestMapping("/Outlinks")
    public ReturnObj selectAll(SearchOutlinkman outlinkman){
        return outLinkmanService.selectAll(outlinkman);
    };
    @GetMapping("/types")
    public List<TboutlinkmanType> types(){
        return outLinkmanService.types();
    };
    @DeleteMapping("/del")
    public ReturnObj del(Integer id){
        return outLinkmanService.del(id);
    };
    @DeleteMapping("/delAll")
    public ReturnObj delAll(@RequestParam("ids[]") Integer[] ids){
        return outLinkmanService.delAll(ids);
    };

    @PostMapping("/doAdd")
    public Map<String,String> doAdd(Tboutlinkman tboutlinkman){
        return outLinkmanService.doAdd(tboutlinkman);
    };
    @PostMapping("/doUpdate")
    public Map<String,String> doUpdate(Tboutlinkman tboutlinkman){
        return outLinkmanService.doUpdate(tboutlinkman);
    };
}
