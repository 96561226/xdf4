package com.aaa.pojo.plans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbTaskCharge {
    private Long task_cid;
    private Long task_id;
    private Long charge_emp_id;
    private String emp_name;
    private Integer state;
    private String state_name;
}
