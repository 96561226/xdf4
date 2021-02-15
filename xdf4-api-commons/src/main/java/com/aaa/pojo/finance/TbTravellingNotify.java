package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTravellingNotify {

  private Long id;
  private Long travellingId;
  private Long empId;
  private Long state;

  public TbTravellingNotify(TbTravellingNotifyVo notifyVo){
    this.id = notifyVo.getId();
    this.travellingId = notifyVo.getTravellingId();
    this.empId = notifyVo.getEmpId();
    this.state = notifyVo.getState();
  }
  public TbTravellingNotify(Long empId,Long travellingId){
    this.empId = empId;
    this.travellingId = travellingId;
  }
}
