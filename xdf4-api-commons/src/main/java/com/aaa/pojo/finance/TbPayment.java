package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbPayment {

  private Long paymentId;
  private String paymentNo;
  private String theme;
  private Long empId;
  private Long deptId;
  private Date applyDate;
  private String cause;
  private double money;
  private String capital;
  private String units;
  private Long contract;
  private Long sort;
  private String paymentMethod;
  private String accessory;
  private Date endDate;
  private Long state;
}
