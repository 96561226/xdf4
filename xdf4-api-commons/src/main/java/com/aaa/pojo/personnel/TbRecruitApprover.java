package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbRecruitApprover {

  private Long id;
  private Long recruitId;
  private Long empId;
  private Long state;
  private String remark;
  public TbRecruitApprover(Long recruitId,Long empId){
    this.recruitId = recruitId;
    this.empId = empId;
  }

}
