package com.aaa.mapper.entry;

import com.aaa.pojo.personnel.SearchEntry;
import com.aaa.pojo.personnel.TbEntry;
import com.aaa.pojo.personnel.TbEntryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface EntryMapper {
    //入职  方法
    //新增入职申请表
    int addEntry(TbEntry entry);
    //作废入职申请表
    int updateEntry(TbEntry entry);
    //    生成编号
    String selNo(@Param("noName") String noName);
    //条件查询入职申请表
    List<TbEntryVo> selectEntry(SearchEntry entry);

}
