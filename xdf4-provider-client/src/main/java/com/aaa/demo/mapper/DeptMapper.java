package com.aaa.demo.mapper;

import com.aaa.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface DeptMapper {
    List<Dept> selectAll();
}
