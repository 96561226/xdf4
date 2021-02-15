package com.aaa.demo.service;

import com.aaa.demo.mapper.ClientTypeMapper;
import com.aaa.pojo.client.TbclientType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ClientTypeServiceImpl implements ClientTypeService {
    @Autowired
    ClientTypeMapper clientTypeMapper;
    @Override
    public List<TbclientType> selectAll() {
        return clientTypeMapper.selectAll();
    }
}
