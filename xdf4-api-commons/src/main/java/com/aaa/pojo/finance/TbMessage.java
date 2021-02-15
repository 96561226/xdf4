package com.aaa.pojo.finance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbMessage {

  private Long messageId;
  private String expenseType;
  private Long money;
  private String opposite;
  private String handlerName;
}
