package com.aaa.pojo.conference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConferenceroomPropertyVo {
  private Long id;
  private Long propertyId;
  private Long conferenceRoomId;
  private String propertyNo;
  private String propertyName;
}
