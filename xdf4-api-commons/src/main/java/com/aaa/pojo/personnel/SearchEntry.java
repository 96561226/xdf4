package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchEntry {
  private Long entryId;
  private String entryNo;;
  private Long empId;
  private Long deptId;
  private Long roleId;
  private Long state;
  private Integer page;

  private Integer limit;

  public SearchEntry(TbEntry entry){
    this.entryId = entry.getEntryId();
    this.entryNo = entry.getEntryNo();
    this.empId = entry.getEmpId();
    this.deptId = entry.getDeptId();
    this.roleId = entry.getRoleId();
    this.state = entry.getState();
  }


}
