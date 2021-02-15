package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTransferApprover {

  private Long id;
  private Long transferId;
  private Long empId;
  private Integer state;
  private String remark;

  public TbTransferApprover(Long transferId,Long empId){
    this.transferId = transferId;
    this.empId = empId;
  }

}
