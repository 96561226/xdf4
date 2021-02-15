package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbRecruit {

  private Long recruitId;
  private String recruitNo;
  private Long empId;
  private Long deptId;
  private String theme;
  private Long roleId;
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


}
