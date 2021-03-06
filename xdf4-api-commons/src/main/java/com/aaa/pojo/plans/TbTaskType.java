package com.aaa.pojo.plans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbTaskType {
    private Long task_tid;
    private String name;
    private String remark;
}
