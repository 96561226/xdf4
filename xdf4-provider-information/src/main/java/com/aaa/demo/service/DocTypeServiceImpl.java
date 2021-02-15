package com.aaa.demo.service;

import com.aaa.demo.mapper.DocTypeMapper;
import com.aaa.pojo.informaction.TbdocumentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class DocTypeServiceImpl implements DocTypeService {
    @Autowired
    DocTypeMapper docTypeMapper;
    @Override
    public List<TbdocumentType> selectAll() {
        return docTypeMapper.selectAll();
    }
}
