package com.aaa.mapper.travelling;

import com.aaa.pojo.finance.TbTravellingNotify;
import com.aaa.pojo.finance.TbTravellingNotifyVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TravellingNotifyMapper {
    //根据差旅费报销表id查询
    List<TbTravellingNotifyVo> selectTravellingNotify(Integer travellingId);
//    添加差旅费报销表知会人
    int insertTravellingNotify(TbTravellingNotify travellingNotify);
    // 查询差旅费报销知会人
    List<TbTravellingNotifyVo> selectTravellingNotifyById(Integer travellingId);
}
