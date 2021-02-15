package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTravellingApprover {

  private Long id;
  private Long travellingId;
  private Long empId;
  private Long state;
  private String remark;

  public TbTravellingApprover(TbTravellingVo travellingVo) {
    this.empId = travellingVo.getApproverId();
    this.remark = travellingVo.getRemark();
  }
  public TbTravellingApprover(Long travellingId,Long empId) {
    this.empId = empId;
    this.travellingId = travellingId;
  }
}
