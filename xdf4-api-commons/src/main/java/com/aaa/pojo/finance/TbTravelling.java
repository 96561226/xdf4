package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTravelling {

  private Long travellingId;
  private String travellingNo;
  private Long empId;
  private Long deptId;
  private Date applyDate;
  private String cause;
  private String accessory;
  private Long state;

  public TbTravelling(TbTravellingVo travellingVo){
    this.travellingId = travellingVo.getTravellingId();
    this.travellingNo = travellingVo.getTravellingNo();
    this.empId = travellingVo.getEmpId();
    this.deptId = travellingVo.getDeptId();
    this.applyDate = travellingVo.getApplyDate();
    this.cause = travellingVo.getCause();
    this.accessory = travellingVo.getAccessory();
  }


}
