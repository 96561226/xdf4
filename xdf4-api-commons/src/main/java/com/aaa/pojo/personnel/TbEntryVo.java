package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbEntryVo {

  private Long entryId;
  private String entryNo;
  private Long empId;
  private String teEmpName;
  private String empName;
  private String theme;
  private Long deptId;
  private String deptName;
  private Long roleId;
  private String roleName;
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
  private String stateName;
  private List<TbEntryApproverVo> entryApproverVos;
  private List<TbEntryNotifyVo> entryNotifyVos;

}
