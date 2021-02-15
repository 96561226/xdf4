package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbIncomeVo {

  private Long incomeId;
  private String incomeNo;
  private Date incomeDate;
  private Long involveType;
  private String paymentType;
  private Long money;
  private Long gathering;
  private String gatheringName;
  private Long register;
  private String registerName;
  private Long empId;
  private String empName;
  private Long deptId;
  private String deptName;
  private String units;
  private Long contract;
  private String pname;
  private String incomeDeclare;
  private Long state;
  private String stateName;
}
