package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbIncomeNotify {

  private long id;
  private long incomeId;
  private long empId;
  private long state;
}
