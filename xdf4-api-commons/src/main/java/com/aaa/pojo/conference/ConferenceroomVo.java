package com.aaa.pojo.conference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConferenceroomVo {
    private Long conferenceRoomId;
    private String conferenceRoomNo;
    private String conferenceRoomName;
    private String conferenceRoomPic;
    private Integer state;
    private List<TbProperty> propertys;
}
