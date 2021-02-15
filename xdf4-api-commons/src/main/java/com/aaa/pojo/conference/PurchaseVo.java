package com.aaa.pojo.conference;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseVo {
    private Long purchaseId;
    private String purchaseNo;
    private String purchaseName;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date purchaseBuytime;
    private String purchaseManufacturer;
    private Integer purchaseUnivalence;
    private String purchasePlace;
    private Integer purchaseState;
    private Long typeId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date purchaseCreateTime;
    private Long empId;
    private String empNo;
    private String empName;
    private String remark;
    private Integer state;

    private List<TbPurchaseApprover> tbPurchaseApprovers;

    private Long ymID;

    private Integer page;
    private Integer limit;
}
