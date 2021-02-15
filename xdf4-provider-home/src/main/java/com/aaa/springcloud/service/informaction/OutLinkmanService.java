package com.aaa.springcloud.service.informaction;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.informaction.SearchOutlinkman;
import com.aaa.pojo.informaction.Tboutlinkman;
import com.aaa.pojo.informaction.TboutlinkmanType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@FeignClient(value = "XDF4-PROVIDER-INFORMATION",contextId = "outLinkId")
public interface OutLinkmanService {
    @RequestMapping("/outlinks/Outlinks")
    public ReturnObj selectAll(@RequestBody SearchOutlinkman outlinkman);
    @GetMapping("/outlinks/types")
    public List<TboutlinkmanType> types();
    @DeleteMapping("/outlinks/del")
    public ReturnObj del(@RequestParam("id") Integer id);
    @DeleteMapping("/outlinks/delAll")
    public ReturnObj delAll(@RequestParam("ids[]") Integer[] ids);

    @PostMapping("/outlinks/doAdd")
    public Map<String,String> doAdd(@RequestBody Tboutlinkman tboutlinkman);
    @PostMapping("/outlinks/doUpdate")
    public Map<String,String> doUpdate(@RequestBody Tboutlinkman tboutlinkman);
}
