package com.aaa.demo.service;

import com.aaa.demo.mapper.EmpMapper;
import com.aaa.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpMapper empMapper;
    @Override
    public List<Emp> selectAll() {
        return empMapper.selectAll();
    }
}
