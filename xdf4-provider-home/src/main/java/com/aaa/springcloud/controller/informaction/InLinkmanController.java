package com.aaa.springcloud.controller.informaction;

import com.aaa.pojo.Dept;
import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.informaction.SearchInlinkman;
import com.aaa.pojo.informaction.Tbinlinkman;
import com.aaa.springcloud.service.informaction.InLinkmanService;
import com.aaa.springcloud.util.BaseController;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/inlinks")
public class InLinkmanController extends BaseController {
    @Autowired
    InLinkmanService inLinkmanService;

    @RequestMapping("/Inlinks")
    public ReturnObj selectAll( SearchInlinkman inlinkman){
        return inLinkmanService.selectAll(inlinkman);
    }

    @GetMapping("/depts")
    public List<Dept> depts(){
        return inLinkmanService.depts();
    }

    @GetMapping("/emps")
    public List<Emp> emps(){
        return inLinkmanService.emps();
    }

    @DeleteMapping("/del")
    public ReturnObj del(@Param("id") Integer id){
        return inLinkmanService.del(id);
    }
    @DeleteMapping("/delAll")
    public ReturnObj delAll(@RequestParam("ids[]") Integer[] ids){
        return inLinkmanService.delAll(ids);
    }
    @RequestMapping("/doUpload")
    public Map<String,String> doUpload(MultipartFile file) {
        return inLinkmanService.doUpload(file);
    }

    @PostMapping("/doAdd")
    public Map<String,String> doAdd( Tbinlinkman tbinlinkman){
        return inLinkmanService.doAdd(tbinlinkman);
    }
    @PostMapping("/doUpdate")
    public Map<String,String> doUpdate(Tbinlinkman tbinlinkman){
        System.out.println(tbinlinkman);
        return inLinkmanService.doUpdate(tbinlinkman);
    }
}
