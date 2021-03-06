package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbRecruitVo {

  private Long recruitId;
  private String recruitNo;
  private Long empId;
  private Long deptId;
  private String  deptName;
  private String empName;
  private String theme;
  private Long roleId;
  private String roleName;
  private Long number;
  private Date arrivalDate;
  private String cause;
  private String content;
  private String foreignRequire;
  private Integer minAge;
  private Integer maxAge;
  private String sex;
  private String education;
  private String major;
  private String site;
  private String experience;
  private Date applyDate;
  private Date endDate;
  private Long state;
  private String stateName;
  private List<TbRecruitNotify> recruitNotifies;
  private List<TbRecruitApprover> recruitApprovers;


}
