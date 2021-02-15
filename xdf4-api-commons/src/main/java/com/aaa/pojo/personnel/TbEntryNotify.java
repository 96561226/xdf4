package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbEntryNotify {

  private Long id;
  private Long entryId;
  private Long empId;
  private Long state;

  public TbEntryNotify(Long entryId,Long empId){
    this.empId = empId;
    this.entryId = entryId;
  }

}
