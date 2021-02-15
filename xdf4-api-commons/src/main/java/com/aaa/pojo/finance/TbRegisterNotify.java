package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbRegisterNotify {

  private Long id;
  private Long registerId;
  private Long empId;
  private Long state;

}
