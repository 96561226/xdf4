package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbPerformance {

  private Long performanceId;
  private String performanceNo;
  private Long principal;
  private Long examineName;
  private Long deptId;
  private Long roleId;
  private Long examineDimensionId;
  private String evaluate;
  private String managersEvaluate;
  private Date applyTime;
  private Long state;


}
