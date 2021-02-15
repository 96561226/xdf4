package com.aaa.springcloud.service.informaction;

import com.aaa.pojo.Dept;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.informaction.SearchDocDustbin;
import com.aaa.pojo.informaction.SearchDocument;
import com.aaa.pojo.informaction.Tbdocument;
import com.aaa.pojo.informaction.TbdocumentType;
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
@FeignClient(value = "XDF4-PROVIDER-INFORMATION",contextId = "documentId")
public interface DocumentService {

    @RequestMapping("/document/Documents")
    public ReturnObj selectAll(@RequestBody SearchDocument document);

    @GetMapping("/document/depts")
    public List<Dept> depts();

    @GetMapping("/document/types")
    public List<TbdocumentType> types();

    @DeleteMapping("/document/del")
    public ReturnObj del(@RequestParam("id") Integer id);
    @DeleteMapping("/document/delAll")
    public ReturnObj delAll(@RequestParam("ids[]") Integer[] ids);
    @PostMapping("/document/doAdd")
    public Map<String,String> doAdd(@RequestBody Tbdocument tbdocument);
    @PostMapping("/document/doUpdate")
    public Map<String,String> doUpdate(@RequestBody Tbdocument tbdocument);

    /*对文档进行删除后的恢复 查看*/
    @RequestMapping("/document/DocDustbins")
    public ReturnObj selectDustbin(@RequestBody SearchDocDustbin docDustbin);

    @DeleteMapping("/document/deldustbin")
    public ReturnObj deldustbin(@RequestParam("id") Integer id);
    @DeleteMapping("/document/delDustbin")
    public ReturnObj delDustbin(@RequestParam("ids[]") Integer[] ids);

    /*上传文档*/
    @RequestMapping(value = "/document/doUpload",consumes = "multipart/form-data")
    public Map<String,String> doUpload(@RequestPart("file") MultipartFile file);
}
