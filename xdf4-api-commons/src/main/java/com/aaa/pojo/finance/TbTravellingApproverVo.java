package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTravellingApproverVo {

  private Long id;
  private Long travellingId;
  private Long empId;
  private String empName;
  private Long state;
  private String  stateName;
  private String remark;

  public TbTravellingApproverVo(TbTravellingVo travellingVo) {
    this.empId = travellingVo.getApproverId();
    this.remark = travellingVo.getRemark();
  }
  public TbTravellingApproverVo(Long empId, Long travellingId) {
    this.empId = empId;
    this.travellingId = travellingId;
  }
}
