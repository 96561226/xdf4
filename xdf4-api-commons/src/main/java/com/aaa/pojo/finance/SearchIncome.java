package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchIncome {

  private Long incomeId;
  private String incomeNo;
  private Long register;
  private Long empId;
  private Long deptId;
  private Long gathering;
  private Long involveType;
  private Long state;
  private Integer page;

  private Integer limit;

  public SearchIncome(TbIncome income){
    this.incomeId = income.getIncomeId();
    this.incomeNo = income.getIncomeNo();
    this.register = income.getRegister();
    this.empId = income.getEmpId();
    this.deptId = income.getDeptId();
    this.gathering = income.getGathering();
    this.involveType = income.getInvolveType();
  }
}
