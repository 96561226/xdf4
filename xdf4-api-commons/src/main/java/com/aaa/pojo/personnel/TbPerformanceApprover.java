package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbPerformanceApprover {

  private Long id;
  private Long performanceId;
  private Long empId;
  private Long state;
  private String remark;


}
