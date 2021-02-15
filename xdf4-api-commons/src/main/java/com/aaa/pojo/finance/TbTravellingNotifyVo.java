package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTravellingNotifyVo {

  private Long id;
  private Long travellingId;
  private Long empId;
  private String empName;
  private Long state;
  private String stateName;

}
