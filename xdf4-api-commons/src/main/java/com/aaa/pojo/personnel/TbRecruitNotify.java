package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbRecruitNotify {

  private Long id;
  private Long recruitId;
  private Long empId;
  private Long state;

  public TbRecruitNotify(Long recruitId,Long empId){
    this.recruitId = recruitId;
    this.empId = empId;
  }

}
