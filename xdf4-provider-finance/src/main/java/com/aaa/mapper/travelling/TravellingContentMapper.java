package com.aaa.mapper.travelling;

import com.aaa.pojo.finance.TbTravellingContent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TravellingContentMapper {
    //根据差旅费报销表id查询详情
    List<TbTravellingContent> selectTravellingContent(Integer travellingId);
//    添加差旅费报销表详情信息
    int insertTravellingContent(TbTravellingContent travellingContent);

    String selTravellingNo();

    // 查询差旅费报销表详情信息
    List<TbTravellingContent> selectTravellingContentById(Integer travellingId);
}


