package com.aaa.demo.mapper;

import com.aaa.pojo.Emp;
import com.aaa.pojo.informaction.TboutlinkmanType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface OutTypeMapper {
    List<TboutlinkmanType> selectAll();
}
