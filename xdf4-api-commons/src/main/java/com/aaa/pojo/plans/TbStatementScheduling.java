package com.aaa.pojo.plans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbStatementScheduling {
    private Long statement_sid;
    private Long sid;
    private String scheduling;
}
