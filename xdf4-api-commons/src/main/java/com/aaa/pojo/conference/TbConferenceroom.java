package com.aaa.pojo.conference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbConferenceroom {
  private Long conferenceRoomId;
  private String conferenceRoomNo;
  private String conferenceRoomName;
  private String conferenceRoomPic;
  private Integer state;
}
