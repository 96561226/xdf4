package com.aaa.springcloud.service.informaction;

import com.aaa.pojo.Dept;
import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.informaction.SearchInlinkman;
import com.aaa.pojo.informaction.Tbinlinkman;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@FeignClient(value = "XDF4-PROVIDER-INFORMATION",contextId = "inLinkId")
public interface InLinkmanService {
    @RequestMapping("/inLinks/Inlinks")
    public ReturnObj selectAll(@RequestBody SearchInlinkman inlinkman);

    @GetMapping("/inLinks/depts")
    public List<Dept> depts();

    @GetMapping("/inLinks/emps")
    public List<Emp> emps();

    @DeleteMapping("/inLinks/del")
    public ReturnObj del(@RequestParam("id") Integer id);
    @DeleteMapping("/inLinks/delAll")
    public ReturnObj delAll(@RequestParam("ids[]") Integer[] ids);
    @RequestMapping(value = "/inLinks/doUpload",consumes = "multipart/form-data")
    public Map<String,String> doUpload(@RequestPart("file") MultipartFile file);

    @PostMapping("/inLinks/doAdd")
    public Map<String,String> doAdd(@RequestBody Tbinlinkman tbinlinkman);
    @PostMapping("/inLinks/doUpdate")
    public Map<String,String> doUpdate(@RequestBody Tbinlinkman tbinlinkman);
}
