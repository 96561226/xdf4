package com.aaa.pojo.conference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbConferenceroomProperty {
  private Long id;
  private Long propertyId;
  private Long conferenceRoomId;
}
