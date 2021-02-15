package com.aaa.pojo.plans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*工作计划*/
public class TbPlan {
    private Long plan_id;
    private String plan_no;
    private String title;
    private Long dept_id;
    private Long emp_id;
    private Long parent_id;
    private Date cdate;
    private Date sdate;
    private Date edate;
    private Integer type;
    private Integer state;
}
