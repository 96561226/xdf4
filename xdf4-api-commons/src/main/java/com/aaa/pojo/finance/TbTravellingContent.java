package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTravellingContent {

  private Long id;
  private Long travellingId;
  private String startStopTime;
  private String startStopAddress;
  private String description;
  private Double tramp;
  private Double city;
  private Double stay;
  private Double evection;
  private Double others;


}
