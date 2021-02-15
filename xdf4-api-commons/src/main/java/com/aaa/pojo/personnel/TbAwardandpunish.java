package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbAwardandpunish {

  private Long awardAndPunishId;
  private String awardAndPunishNo;
  private String theme;
  private Long empId;
  private Long deptId;
  private Date applyDate;
  private Long involveEmp;
  private Long type;
  private String cause;
  private String result;
  private String accessory;
  private Date endDate;
  private Long state;


}
