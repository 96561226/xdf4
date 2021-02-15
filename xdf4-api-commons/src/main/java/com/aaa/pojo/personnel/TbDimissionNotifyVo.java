package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbDimissionNotifyVo {

  private Long id;
  private Long dimissionId;
  private Long empId;
  private String empName;
  private Long state;
  private String stateName;


}
