package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchTravelling {

  private Long travellingId;
  private String travellingNo;
  private Long empId;
  private Long deptId;
  private Long state;
  private Integer page;

  private Integer limit;

  public SearchTravelling(TbTravelling vo){
    this.travellingNo = vo.getTravellingNo();
    this.empId = vo.getEmpId();
    this.deptId = vo.getDeptId();
    this.state = vo.getState();
  }
}
