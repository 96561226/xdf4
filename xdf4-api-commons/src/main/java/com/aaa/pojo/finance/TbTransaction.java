package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTransaction {

  private Long transactionId;
  private String transactionNo;
  private String menuName;
  private String menuUrl;
  private Long parentId;
  private Long type;
  private String remark;
  private Long state;
}
