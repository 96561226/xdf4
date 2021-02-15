package com.aaa.springcloud.mapper;

import com.aaa.pojo.conference.ConferenceroomVo;
import com.aaa.pojo.conference.TbConferenceroom;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ConferenceroomMapper {
    //动态查询会议室与设备
    List<ConferenceroomVo> selConferenceRoomsByDT(TbConferenceroom tbfr);
    //查询全部的会议室 单表查询
    List<TbConferenceroom> selTbConferenceroom();
}
