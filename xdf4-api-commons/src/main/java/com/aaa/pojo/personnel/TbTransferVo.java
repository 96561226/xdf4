package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTransferVo {

  private Long transferId;
  private String transferNo;
  private String theme;
  private Long empId;
  private String empName;
  private Long deptId;
  private String deptName;
  private Long roleId;
  private String roleName;
  private Long newDeptId;
  private String newDeptName;
  private Long newRoleId;
  private String newRoleName;
  private String cause;
  private Long typeId;
  private String typeName;
  private String opinion;
  private String newOpinion;
  private Date applyDate;
  private Date endDate;
  private Long state;
  private String stateName;
  List<TbTransferApproverVo> transferApproverVos;
  List<TbTransferNotifyVo> transferNotifyVos;


}
