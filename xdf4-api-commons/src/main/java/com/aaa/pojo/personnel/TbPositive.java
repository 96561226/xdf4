package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbPositive {

  private Long positiveId;
  private String positiveNo;
  private String theme;
  private Long empId;
  private Date applyDate;
  private Long roleId;
  private Date entryDate;
  private Date positiveDate;
  private String content;
  private String score;
  private String issue;
  private String improve;
  private Date endDate;
  private Long state;

}
