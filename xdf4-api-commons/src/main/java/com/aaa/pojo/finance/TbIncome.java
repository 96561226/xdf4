package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbIncome {

  private Long incomeId;
  private String incomeNo;
  private Date incomeDate;
  private Long involveType;
  private Double money;
  private Long gathering;
  private Long register;
  private Long empId;
  private Long deptId;
  private String units;
  private Long contract;
  private String incomeDeclare;
  private Long state;

}
