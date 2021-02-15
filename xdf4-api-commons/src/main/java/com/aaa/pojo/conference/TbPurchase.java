package com.aaa.pojo.conference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbPurchase {
  private Long purchaseId;
  private String purchaseNo;
  private String purchaseName;
  private Date purchaseBuytime;
  private String purchaseManufacturer;
  private Integer purchaseUnivalence;
  private String purchasePlace;
  private Integer purchaseState;
  private Long typeId;
  private Date purchaseCreateTime;
  private Long empId;
  private String remark;
  private Integer state;
}
