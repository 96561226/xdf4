package com.aaa.pojo.plans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbPlanAction {
    private Long plan_aid;
    private Long pid;
    private Long action_emp_id;
    private String emp_name;
}
