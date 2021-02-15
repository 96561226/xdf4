package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbExpenseApprover {

  private Long id;
  private Long expenseId;
  private Long empId;
  private Long state;
  private String remark;

}
