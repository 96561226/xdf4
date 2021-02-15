package com.aaa.pojo.conference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyApproverVo {
  private Long id;
  private Long applyId;
  private Long empId;
  private String empNo;
  private String empName;
  private String remark;
  private Integer state;
}
