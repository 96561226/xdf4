package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbPaymentNotify {

  private Long id;
  private Long paymentId;
  private Long empId;
  private Long state;

}
