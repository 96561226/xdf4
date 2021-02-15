package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbRegister {

  private Long registerId;
  private String registerNo;
  private String theme;
  private Long empId;
  private Long deptId;
  private Date applyDate;
  private String registerDeclare;
  private String units;
  private Long contract;
  private Double money;
  private String capital;
  private java.sql.Date invoiceTime;
  private Long invoice;
  private String accessory;
  private Date endDate;
  private Long state;

}
