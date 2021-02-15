package com.aaa.demo.service;

import com.aaa.demo.mapper.OutTypeMapper;
import com.aaa.pojo.informaction.TboutlinkmanType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OutTypeServiceImpl implements OutTypeService {
    @Autowired
    OutTypeMapper outTypeMapper;
    @Override
    public List<TboutlinkmanType> selectAll() {
        return outTypeMapper.selectAll();
    }
}
