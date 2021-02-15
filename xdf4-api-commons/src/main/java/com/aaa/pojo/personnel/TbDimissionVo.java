package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbDimissionVo {

  private Long dimissionId;
  private String dimissionNo;
  private Long empId;
  private String empName;
  private Date applyDate;
  private Long deptId;
  private String deptName;
  private Long roleId;
  private String roleName;
  private Date dimissionDate;
  private Long typeId;
  private String typeName;
  private String cause;
  private String connect;
  private String opinion;
  private Date endDate;
  private Long state;
  private String stateName;
  List<TbDimissionNotifyVo> dimissionNotifyVos;
  List<TbDimissionApproverVo> dimissionApproverVos;


}
