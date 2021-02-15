package com.aaa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRole {
    private Long transaction_rid;
    private Long role_id;
    private Long tid;
    private Integer state;
}
