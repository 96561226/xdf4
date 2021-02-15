package com.aaa.demo.controller;

import com.aaa.demo.service.DeptService;
import com.aaa.demo.service.EmpService;
import com.aaa.demo.service.InLinkmanService;
import com.aaa.demo.util.BaseController;
import com.aaa.pojo.Dept;
import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.informaction.SearchInlinkman;
import com.aaa.pojo.informaction.Tbinlinkman;
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
@RequestMapping("/inLinks")
public class InLinkmanController extends BaseController {
    @Autowired
    InLinkmanService inLinkmanService;
    @Autowired
    DeptService deptService;
    @Autowired
    EmpService empService;
    @RequestMapping("/Inlinks")
    public ReturnObj selectAll(@RequestBody SearchInlinkman inlinkman){
        ReturnObj obj =  inLinkmanService.selectAll(inlinkman);
        return obj;
    }

    @GetMapping("/depts")
    public List<Dept> depts(){
        List<Dept> depts = deptService.selectAll();
        return depts;
    }

    @GetMapping("/emps")
    public List<Emp> emps(){
        List<Emp> emps = empService.selectAll();
        return emps;
    }

    @DeleteMapping("/del")
    public ReturnObj del(@RequestParam("id") Integer id){
        inLinkmanService.del(id);
        return new ReturnObj(0,"",0,"success");
    }
    @DeleteMapping("/delAll")
    public ReturnObj delAll(@RequestParam("ids[]") Integer[] ids){
        inLinkmanService.delAll(ids);
        return new ReturnObj(0,"",0,"success");
    }
    @RequestMapping("/doUpload")
    public Map<String,String> doUpload(@RequestPart("file") MultipartFile file) throws IOException {

        Map<String,String> result = new HashMap<>();
        //判断是否为空
        if(null ==file){
            result.put("type","error");
            result.put("msg","请选择上传的图片");
            return result;
        }
        //判断大小
        long size = file.getSize();
        if(size > 2000000){
            result.put("type","error");
            result.put("msg","上传的图片超过限定大小，请上传2M以内的图片！");
            return result;
        }
        //拿到图片的后缀
        int index = file.getOriginalFilename().lastIndexOf(".");
        String suffix = file.getOriginalFilename().substring(index);
        //判断后缀是否是图片
        if(!".jpg,.jpeg,.png,.gif".toUpperCase().contains(suffix.toUpperCase())){
            result.put("type","error");
            result.put("msg","必须上传指定格式的图片.jpg,.jpeg,.png,.gif");
            return result;
        }
        //修改文件的名字
        String newFileName = System.currentTimeMillis()+""+suffix;
        //建立文件
        File pfile = new File(this.REAL_PATH,newFileName);
        //写入磁盘
        file.transferTo(pfile);//把文件写入到指定的路径中；
        //返回给前端数据
        result.put("type","success");
        result.put("msg","上传成功！");
        result.put("fileName",newFileName);
        result.put("visitPic",this.VISIT_PATH+newFileName);
        result.put("filePath",this.VISIT_PATH);
        return result;
    }

    @PostMapping("/doAdd")
    public Map<String,String> doAdd(@RequestBody Tbinlinkman tbinlinkman){
        int result = inLinkmanService.insert(tbinlinkman);
        Map<String,String> map = new HashMap<>();
        if(result>0){
            map.put("result","success");
        }else{
            map.put("result","error");
        }
        return map;
    }
    @PostMapping("/doUpdate")
    public Map<String,String> doUpdate(@RequestBody Tbinlinkman tbinlinkman){
        int result = inLinkmanService.update(tbinlinkman);
        Map<String,String> map = new HashMap<>();
        if(result>0){
            map.put("result","success");
        }else{
            map.put("result","error");
        }
        return map;
    }
}
