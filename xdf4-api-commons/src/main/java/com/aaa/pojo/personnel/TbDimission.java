package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbDimission {

  private Long dimissionId;
  private String dimissionNo;
  private Long empId;
  private Date applyDate;
  private Long deptId;
  private Long roleId;
  private Date dimissionDate;
  private Long typeId;
  private String cause;
  private String connect;
  private String opinion;
  private Date endDate;
  private Long state;


}
