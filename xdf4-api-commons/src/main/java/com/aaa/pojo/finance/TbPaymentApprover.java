package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbPaymentApprover {

  private Long id;
  private Long paymentId;
  private Long empId;
  private Long state;
  private String remark;

}
