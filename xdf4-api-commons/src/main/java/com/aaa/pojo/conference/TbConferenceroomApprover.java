package com.aaa.pojo.conference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbConferenceroomApprover {
  private Long id;
  private Long applyId;
  private Long empId;
  private Integer state;
}
