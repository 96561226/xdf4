package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbBusiness {

  private Long businessId;
  private String businessNo;
  private Long preparer;
  private Long empId;
  private Date applyTime;
  private Long roleId;
  private Long deptId;
  private Long phone;
  private Long typeId;
  private String address;
  private Long overtime;
  private Long leaveType;
  private String goOut;
  private Date beginTime;
  private Date endTime;
  private Double sum;
  private String history;
  private String cause;
  private Integer state;


}
