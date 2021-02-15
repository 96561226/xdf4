package com.aaa.demo.service;

import com.aaa.demo.mapper.AfterTypeMapper;
import com.aaa.pojo.client.TbafterType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AfterTypeServiceImpl implements AfterTypeService {
    @Autowired
    AfterTypeMapper afterTypeMapper;
    @Override
    public List<TbafterType> selectAll() {
        return afterTypeMapper.selectAll();
    }
}
