package com.aaa.pojo.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbPactApproverVo {
    private Integer id;
    private Integer p_id;
    private Integer emp_id;
    private String emp_name;
    private Integer state;
    private String state_name;
}
