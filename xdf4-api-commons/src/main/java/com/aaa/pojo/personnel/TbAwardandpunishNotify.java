package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbAwardandpunishNotify {

  private Long id;
  private Long awardAndPunishId;
  private Long empId;
  private Long state;

}
