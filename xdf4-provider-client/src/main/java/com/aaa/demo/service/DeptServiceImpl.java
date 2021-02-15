package com.aaa.demo.service;

import com.aaa.demo.mapper.DeptMapper;
import com.aaa.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeptServiceImpl implements DeptService{
    @Autowired
    DeptMapper deptMapper;
    @Override
    public List<Dept> selectAll() {
        return deptMapper.selectAll();
    }
}
