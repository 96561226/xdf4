package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbExpense {

  private Long expenseId;
  private String expenseNo;
  private String theme;
  private Long empId;
  private Long deptId;
  private Date applyDate;
  private Date reimburseDate;
  private Long expenseMessage;
  private String accessory;
  private Date endDate;
  private Long state;

}
