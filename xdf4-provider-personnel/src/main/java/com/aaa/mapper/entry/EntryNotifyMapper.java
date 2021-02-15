package com.aaa.mapper.entry;

import com.aaa.pojo.personnel.TbEntryNotify;
import com.aaa.pojo.personnel.TbEntryNotifyVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface EntryNotifyMapper {
    /*根据招聘id查询知会人*/
    List<TbEntryNotifyVo> selectEntryNotifys(Long id);
    int insertEntryNotify(TbEntryNotify notify);
}
