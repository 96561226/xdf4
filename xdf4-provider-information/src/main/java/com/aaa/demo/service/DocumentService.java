package com.aaa.demo.service;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.informaction.SearchDocDustbin;
import com.aaa.pojo.informaction.SearchDocument;
import com.aaa.pojo.informaction.Tbdocument;

import java.util.List;


public interface DocumentService {
    int insert(Tbdocument tbdocument);

    ReturnObj selectAll(SearchDocument document);

    int del(Integer id);

    int update(Tbdocument tbdocument);

    Tbdocument findByID(Integer id);

    //批量删除
    boolean delAll(Integer[] ids);

    /*对文档进行删除后的恢复 查看*/
    ReturnObj selectDustbin(SearchDocDustbin docDustbin);

    int deldustbin(Integer id);

    /*批量恢复*/
    boolean delDustbin(Integer[] ids);
}
