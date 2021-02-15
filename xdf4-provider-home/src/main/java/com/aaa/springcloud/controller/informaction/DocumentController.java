package com.aaa.springcloud.controller.informaction;

import com.aaa.pojo.Dept;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.informaction.SearchDocDustbin;
import com.aaa.pojo.informaction.SearchDocument;
import com.aaa.pojo.informaction.Tbdocument;
import com.aaa.pojo.informaction.TbdocumentType;
import com.aaa.springcloud.service.informaction.DocumentService;
import com.aaa.springcloud.util.BaseController;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DocumentController extends BaseController {
    @Autowired
    DocumentService documentService;

    @RequestMapping("/document/Documents")
    public ReturnObj selectAll(SearchDocument document){
        return documentService.selectAll(document);
    };

    @GetMapping("/document/depts")
    public List<Dept> depts(){
        return documentService.depts();
    };

    @GetMapping("/document/types")
    public List<TbdocumentType> types(){
        return documentService.types();
    };

    @DeleteMapping("/document/del")
    public ReturnObj del(Integer id){
        return documentService.del(id);
    };
    @DeleteMapping("/document/delAll")
    public ReturnObj delAll(@RequestParam("ids[]") Integer[] ids){
        return documentService.delAll(ids);
    };
    @PostMapping("/document/doAdd")
    public Map<String,String> doAdd(Tbdocument tbdocument){
        return documentService.doAdd(tbdocument);
    };
    @PostMapping("/document/doUpdate")
    public Map<String,String> doUpdate(Tbdocument tbdocument){
        return documentService.doUpdate(tbdocument);
    };

    /*对文档进行删除后的恢复 查看*/
    @RequestMapping("/document/DocDustbins")
    public ReturnObj selectDustbin(SearchDocDustbin docDustbin){
        return documentService.selectDustbin(docDustbin);
    };

    @DeleteMapping("/document/deldustbin")
    public ReturnObj deldustbin(Integer id){
        return documentService.deldustbin(id);
    };
    @DeleteMapping("/document/delDustbin")
    public ReturnObj delDustbin(@RequestParam("ids[]") Integer[] ids){
        return documentService.delDustbin(ids);
    };

    /*上传文档*/
    @RequestMapping("/document/doUpload")
    public Map<String,String> doUpload(MultipartFile file){
        return documentService.doUpload(file);
    };
}
