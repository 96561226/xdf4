package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTransfer {

  private Long transferId;
  private String transferNo;
  private String theme;
  private Long empId;
  private Long deptId;
  private Long roleId;
  private Long newDeptId;
  private Long newRoleId;
  private String cause;
  private Long typeId;
  private String opinion;
  private String newOpinion;
  private Date applyDate;
  private Date endDate;
  private Long state;


}
