package com.aaa.pojo.plans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbTaskAction {
    private Long task_aid;
    private Long task_id;
    private Long action_emp_id;
    private String emp_name;
}
