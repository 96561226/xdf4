package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbBusinessNotify {

  private Long id;
  private Long businessId;
  private Long empId;
  private Long state;

}
