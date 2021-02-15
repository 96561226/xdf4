package com.aaa.searchpojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchPlan {
    private Long plan_id;
    private String plan_no;
    private String title;
    private Long dept_id;
    private Long emp_id;
    private Long parent_id;
    private String parent_no;
    private Date cdate;
    private Date sdate;
    private Date edate;
    private Integer type;
    private Integer state;

    private Long action_emp_id;
    private Long charge_emp_id;



}
