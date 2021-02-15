package com.aaa.pojo.plans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskVo {
    private Long task_id;
    private String task_no;
    private String title;
    private Long parent_id;
    private String pname;
    private Long dept_id;
    private String dept_name;
    private Long emp_id;
    private String emp_name;
    private Date cdate;
    private Date sdate;
    private Date edate;
    private String remark;
    private Integer type;
    private String type_name;
    private Integer state;
    private String state_name;

    private List<TbTaskAction> taskActions;
    private List<TbTaskScheduling> taskSchedulings;
}
