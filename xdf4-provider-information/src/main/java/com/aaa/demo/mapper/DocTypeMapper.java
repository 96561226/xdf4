package com.aaa.demo.mapper;


import com.aaa.pojo.informaction.TbdocumentType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface DocTypeMapper {
    List<TbdocumentType> selectAll();
}
