package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTransactionDept {

  private Long id;
  private Long deptId;
  private Long tid;
  private Long state;

}
