package com.aaa.demo.controller;

import com.aaa.demo.service.*;
import com.aaa.demo.util.BaseController;
import com.aaa.pojo.Dept;
import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.informaction.SearchDocDustbin;
import com.aaa.pojo.informaction.SearchDocument;
import com.aaa.pojo.informaction.Tbdocument;
import com.aaa.pojo.informaction.TbdocumentType;
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
@RequestMapping("/document")
public class DocumentController extends BaseController{
    @Autowired
    DocumentService documentService;
    @Autowired
    DeptService deptService;
    @Autowired
    DocTypeService docTypeService;

    @RequestMapping("/Documents")
    public ReturnObj selectAll(@RequestBody SearchDocument document){
        ReturnObj obj =  documentService.selectAll(document);
        return obj;
    }

    @GetMapping("/depts")
    public List<Dept> depts(){
        List<Dept> depts = deptService.selectAll();
        return depts;
    }

    @GetMapping("/types")
    public List<TbdocumentType> types(){
        List<TbdocumentType> types = docTypeService.selectAll();
        return types;
    }

    @DeleteMapping("/del")
    public ReturnObj del(@RequestParam("id") Integer id){
        documentService.del(id);
        return new ReturnObj(0,"",0,"success");
    }
    @DeleteMapping("/delAll")
    public ReturnObj delAll(@RequestParam("ids[]") Integer[] ids){
        documentService.delAll(ids);
        return new ReturnObj(0,"",0,"success");
    }
    @PostMapping("/doAdd")
    public Map<String,String> doAdd(@RequestBody Tbdocument tbdocument){
        int result = documentService.insert(tbdocument);
        Map<String,String> map = new HashMap<>();
        if(result>0){
            map.put("result","success");
        }else{
            map.put("result","error");
        }
        return map;
    }
    @PostMapping("/doUpdate")
    public Map<String,String> doUpdate(@RequestBody Tbdocument tbdocument){
        int result = documentService.update(tbdocument);
        Map<String,String> map = new HashMap<>();
        if(result>0){
            map.put("result","success");
        }else{
            map.put("result","error");
        }
        return map;
    }

    /*对文档进行删除后的恢复 查看*/
    @RequestMapping("/DocDustbins")
    public ReturnObj selectDustbin(@RequestBody SearchDocDustbin docDustbin){
        ReturnObj obj =  documentService.selectDustbin(docDustbin);
        return obj;
    }

    @DeleteMapping("/deldustbin")
    public ReturnObj deldustbin(@RequestParam("id") Integer id){
        documentService.deldustbin(id);
        return new ReturnObj(0,"",0,"success");
    }
    @DeleteMapping("/delDustbin")
    public ReturnObj delDustbin(@RequestParam("ids[]") Integer[] ids){
        documentService.delDustbin(ids);
        return new ReturnObj(0,"",0,"success");
    }

    /*上传文档*/
    @RequestMapping("/doUpload")
    public Map<String,String> doUpload(@RequestPart("file") MultipartFile file) throws IOException {

        Map<String,String> result = new HashMap<>();
        //判断是否为空
        if(null ==file){
            result.put("type","error");
            result.put("msg","请选择上传的文档");
            return result;
        }
        //拿到的后缀
        int index = file.getOriginalFilename().lastIndexOf(".");
        String suffix = file.getOriginalFilename().substring(index);
        //判断后缀是否是文档
        if(!".pdf".toUpperCase().contains(suffix.toUpperCase())){
            result.put("type","error");
            result.put("msg","必须上传指定格式的文档.pdf");
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
}
