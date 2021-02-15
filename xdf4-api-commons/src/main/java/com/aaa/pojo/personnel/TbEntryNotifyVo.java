package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbEntryNotifyVo {

  private Long id;
  private Long entryId;
  private Long empId;
  private String empName;
  private Long state;
  private String stateName;


}
