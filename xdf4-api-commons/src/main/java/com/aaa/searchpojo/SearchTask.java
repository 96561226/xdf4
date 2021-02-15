package com.aaa.searchpojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchTask {
    private Long task_id;
    private String task_no;
    private Long parent_id;
    private String parent_no;
    private String title;
    private Long dept_id;
    private Long emp_id;
    private Date cdate;
    private Date sdate;
    private Date edate;
    private String remark;
    private Integer type;
    private Integer state;

    private Long action_emp_id;

    private Integer page;

    private Integer limit;
}
