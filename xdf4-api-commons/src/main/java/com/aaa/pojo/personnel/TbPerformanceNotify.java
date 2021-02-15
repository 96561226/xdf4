package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbPerformanceNotify {

  private Long id;
  private Long performanceId;
  private Long empId;
  private Long state;


}
