package com.aaa.pojo.plans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*工作任务*/
public class TbTask {
    private Long task_id;
    private String task_no;
    private Long parent_id;
    private String title;
    private Long dept_id;
    private Long emp_id;
    private Date cdate;
    private Date sdate;
    private Date edate;
    private String remark;
    private Integer type;
    private Integer state;
}
