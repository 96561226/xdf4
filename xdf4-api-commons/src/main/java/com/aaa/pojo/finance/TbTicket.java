package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTicket {

  private Long ticketId;
  private String ticketNo;
  private String theme;
  private Long empId;
  private Long deptId;
  private Date applyDate;
  private String ticketDeclare;
  private String units;
  private Long contract;
  private Long sort;
  private Long recognition;
  private String account;
  private String address;
  private Long phone;
  private Double money;
  private String capital;
  private Date invoiceTime;
  private Long invoice;
  private String accessory;
  private Date endDate;
  private Long state;

}
