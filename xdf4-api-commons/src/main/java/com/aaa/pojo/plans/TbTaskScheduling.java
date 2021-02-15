package com.aaa.pojo.plans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbTaskScheduling {
    private Long task_sid;
    private Long task_id;
    private String scheduling;
}
