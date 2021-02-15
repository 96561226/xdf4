package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchDimission {
  private Long dimissionId;
  private String dimissionNo;;
  private Long empId;
  private Long deptId;
  private Long roleId;
  private Long state;
  private Integer page;

  private Integer limit;

}
