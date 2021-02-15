package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbTicketApprover {

  private Long id;
  private Long ticketId;
  private Long empId;
  private Long state;
  private String remark;

}
