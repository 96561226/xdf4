package com.aaa.searchpojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchEmp {
    private Long emp_id;
    private String emp_no;
    private String emp_name;
    private Long role_id;
    private Long mgr;
    private Date sdate;
    private Date edate;
    private Double sal;
    private Double comm;
    private Long dept_id;
    private Integer state;

    private Integer page;

    private Integer limit;
}
