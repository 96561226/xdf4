package com.aaa.mapper.dimission;

import com.aaa.pojo.personnel.TbDimissionNotify;
import com.aaa.pojo.personnel.TbDimissionNotifyVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DimissionNotifyMapper {
    /*根据招聘id查询知会人*/
    List<TbDimissionNotifyVo> selectDimissionNotifys(Long id);
    int insertDimissionNotify(TbDimissionNotify notify);
}
