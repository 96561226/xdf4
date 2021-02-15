package com.aaa.pojo.plans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbPlanCharge {
    private Long plan_cid;
    private Long pid;
    private Long charge_emp_id;
    private Integer state;
    private String emp_name;
    private String state_name;
}
