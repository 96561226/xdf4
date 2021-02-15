package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRecruit {
  private Long recruitId;
  private String recruitNo;;
  private Long empId;
  private Long roleId;
  private Long state;
  private Integer page;

  private Integer limit;

  public SearchRecruit(TbRecruit recruit){
    this.recruitNo = recruit.getRecruitNo();
    this.recruitId = recruit.getRecruitId();
    this.empId = recruit.getEmpId();
    this.roleId = recruit.getRoleId();
  }

}
