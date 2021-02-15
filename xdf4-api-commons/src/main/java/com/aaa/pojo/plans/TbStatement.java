package com.aaa.pojo.plans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*工作报告*/
public class TbStatement {
    private Long statement_id;
    private String statement_no;
    private String title;
    private Long dept_id;
    private Long emp_id;
    private Long parent_id;
    private Date cdate;
    private Integer type;
    private Integer state;
}
