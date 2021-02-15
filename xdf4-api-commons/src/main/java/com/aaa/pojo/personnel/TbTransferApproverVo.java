package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTransferApproverVo {

  private Long id;
  private Long transferId;
  private Long empId;
  private String empName;
  private Integer state;
  private String stateName;
  private String remark;

}
