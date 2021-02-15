package com.aaa.pojo.plans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbPlanScheduling {
    private Long plan_sid;
    private Long pid;
    private String scheduling;
    private Date adate;
}
