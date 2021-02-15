package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTravellingVo {

  private Long travellingId;
  private String travellingNo;
  private Long empId;
  private String empName;
  private Long deptId;
  private String deptName;
  private Date applyDate;
  private String cause;
  private String accessory;
  private Long approverId;
  private List<TbTravellingApproverVo> approverName;
  private Long state;
  private String stateName;
  private String remark;
  private List<TbTravellingNotifyVo> travellingNotifies;
  private List<TbTravellingContent> travellingContents;
}
