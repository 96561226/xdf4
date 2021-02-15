package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbPositiveApprover {

  private Long id;
  private Long positiveId;
  private Long empId;
  private Long state;
  private String remark;


}
