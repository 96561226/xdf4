package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbDimissionApprover {

  private Long id;
  private Long dimissionId;
  private Long empId;
  private Long state;
  private String remark;

  public TbDimissionApprover(Long dimissionId,Long empId){
    this.dimissionId = dimissionId;
    this.empId = empId;
  }

}
