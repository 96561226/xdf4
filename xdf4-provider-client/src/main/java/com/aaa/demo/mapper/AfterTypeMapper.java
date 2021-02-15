package com.aaa.demo.mapper;

import com.aaa.pojo.client.TbafterType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface AfterTypeMapper {
    List<TbafterType> selectAll();
}
