package com.aaa.pojo.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbProject {

  private Long projectId;
  private String projectNo;
  private String projectName;
  private Integer projectPredictMoney;
  private Integer projectUseMoney;
  private Date projectBeginTime;
  private Date projectEndTime;
  private Long empId;
  private String projectRemark;
  private Long projectType;
  private Integer projectState;
  private Long documentId;
  private Long taskId;
}
