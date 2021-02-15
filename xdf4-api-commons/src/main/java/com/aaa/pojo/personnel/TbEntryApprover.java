package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TbEntryApprover {

  private Long id;
  private Long entryId;
  private Long empId;
  private Long state;
  private String remark;
  public TbEntryApprover(Long entryId,Long empId){
    this.entryId = entryId;
    this.empId = empId;
  }

}
