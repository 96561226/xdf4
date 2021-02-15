package com.aaa.springcloud.mapper;

import com.aaa.pojo.conference.ConferenceroomPropertyVo;
import com.aaa.pojo.conference.TbConferenceroomProperty;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ConferenceroomPropertyMapper {
    //查询一个会议室的所有设备
    List<ConferenceroomPropertyVo> selRoomProperById(@Param("conferenceRoomId") Long conferenceRoomId);
    //添加一个资产和会议室的关系
    int addConferenceroomProperty(TbConferenceroomProperty tcp);
    //删除一个资产和会议室的关系
    int delConferenceroomProperty(Long property_id);
}
