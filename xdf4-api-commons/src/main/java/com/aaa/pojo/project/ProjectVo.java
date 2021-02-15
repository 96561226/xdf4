package com.aaa.pojo.project;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectVo {

  private Long projectId;
  private String projectNo;
  private String projectName;
  private Integer projectPredictMoney;
  private Integer projectUseMoney;
  @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
  private Date projectBeginTime;
  @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
  private Date projectEndTime;
  private Long empId;
  private String projectRemark;
  private Long projectType;
  private Integer projectState;
  private Long documentId;
  private Long taskId;

  private String empNo;
  private String empName;

  private String projectTypeName;

  private String title;

  private String dname;
  private String accessory;

  private Integer page;
  private Integer limit;
}
