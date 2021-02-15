package com.aaa.demo.service;

import com.aaa.demo.mapper.DocumentMapper;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.informaction.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    DocumentMapper documentMapper;
    @Override
    public int insert(Tbdocument tbdocument) {
        return documentMapper.insert(tbdocument);
    }

    @Override
    public ReturnObj selectAll(SearchDocument document) {
        int currentPage = document.getPage() == null ? 1:document.getPage();
        int pageSize = document.getLimit() == null ? 3:document.getLimit();
        PageHelper.startPage(currentPage,pageSize);
        List<TbdocumentVo> bs =documentMapper.selectAll(document);
        PageInfo<TbdocumentVo> pageinfo = new PageInfo<TbdocumentVo>(bs);
        Integer total = Integer.valueOf(pageinfo.getTotal()+"");
        List<TbdocumentVo> list = pageinfo.getList();
        return new ReturnObj(0,"",total,list);
    }

    @Override
    public int del(Integer id) {
        int i = documentMapper.insertDustbin(id);
        i = documentMapper.del(id);
        return i;
    }

    @Override
    public int update(Tbdocument tbdocument) {
        return documentMapper.update(tbdocument);
    }

    @Override
    public Tbdocument findByID(Integer id) {
        return documentMapper.findByID(id);
    }

    @Override
    public boolean delAll(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            documentMapper.insertDustbin(id);
            documentMapper.del(id);
        }
        return flag;
    }

    /*对文档进行删除后的恢复 查看*/

    @Override
    public ReturnObj selectDustbin(SearchDocDustbin docDustbin) {
        int currentPage = docDustbin.getPage() == null ? 1:docDustbin.getPage();
        int pageSize = docDustbin.getLimit() == null ? 3:docDustbin.getLimit();
        PageHelper.startPage(currentPage,pageSize);
        List<TbdocdustbinVo> bs =documentMapper.selectDustbin(docDustbin);
        PageInfo<TbdocdustbinVo> pageinfo = new PageInfo<TbdocdustbinVo>(bs);
        Integer total = Integer.valueOf(pageinfo.getTotal()+"");
        List<TbdocdustbinVo> list = pageinfo.getList();
        return new ReturnObj(0,"",total,list);
    }

    @Override
    public int deldustbin(Integer id) {
        int i = documentMapper.insertDoc(id);
        i = documentMapper.deldustbin(id);
        return i;
    }

    @Override
    public boolean delDustbin(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            documentMapper.insertDoc(id);
            documentMapper.deldustbin(id);
        }
        return flag;
    }
}
