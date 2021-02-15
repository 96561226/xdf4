package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTransactionRole {

  private Long id;
  private Long roleId;
  private Long tid;
  private Long state;

}
