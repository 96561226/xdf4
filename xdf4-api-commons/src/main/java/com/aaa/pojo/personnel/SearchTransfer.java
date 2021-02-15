package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchTransfer {
  private Long transferId;
  private String transferNo;;
  private Long empId;
  private Long deptId;
  private Long newDeptId;
  private Long roleId;
  private Long newRoleId;
  private Long state;
  private Integer page;

  private Integer limit;

  public SearchTransfer(TbTransfer transfer){
    this.transferId = transfer.getTransferId();
    this.transferNo = transfer.getTransferNo();
    this.empId = transfer.getEmpId();
    this.deptId = transfer.getDeptId();
    this.roleId = transfer.getRoleId();
    this.state = transfer.getState();
  }


}
