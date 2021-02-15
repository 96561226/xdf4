package com.aaa.demo.mapper;

import com.aaa.pojo.informaction.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface DocumentMapper {
    int insert(Tbdocument tbdocument);

    List<TbdocumentVo> selectAll(SearchDocument document);

    int del(Integer id);

    int update(Tbdocument tbdocument);

    Tbdocument findByID(Integer id);

    /*对文档进行删除后的恢复 查看*/
    int insertDustbin(Integer id);

    int insertDoc(Integer id);

    List<TbdocdustbinVo> selectDustbin(SearchDocDustbin docDustbin);

    int deldustbin(Integer id);
}
