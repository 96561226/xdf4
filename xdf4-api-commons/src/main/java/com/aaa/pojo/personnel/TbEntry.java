package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbEntry {

  private Long entryId;
  private String entryNo;
  private Long empId;
  private String empName;
  private String theme;
  private Long deptId;
  private Long roleId;
  private Date birthday;
  private Date entryDate;
  private String sex;
  private String school;
  private String education;
  private String major;
  private String term;
  private String remarks;
  private Date applyDate;
  private Date endDate;
  private Long state;

}
