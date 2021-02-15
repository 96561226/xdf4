package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbDimissionNotify {

  private Long id;
  private Long dimissionId;
  private Long empId;
  private Long state;
  public TbDimissionNotify(Long dimissionId,Long empId){
    this.empId = empId;
    this.dimissionId = dimissionId;
  }

}
