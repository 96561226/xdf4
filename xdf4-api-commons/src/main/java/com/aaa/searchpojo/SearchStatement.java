package com.aaa.searchpojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchStatement {
    private Long statement_id;
    private String statement_no;
    private String title;
    private Long dept_id;
    private Long emp_id;
    private Long parent_id;
    private String parent_no;
    private Date sdate;
    private Date edate;
    private Integer type;
    private Integer state;

    private Long charge_emp_id;

    private Integer page;

    private Integer limit;

}
