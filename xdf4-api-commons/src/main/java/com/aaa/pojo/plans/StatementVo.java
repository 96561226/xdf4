package com.aaa.pojo.plans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatementVo {
    private Long statement_id;
    private String statement_no;
    private String title;
    private Long parent_id;
    private String pname;
    private Long emp_id;
    private String emp_name;
    private Long dept_id;
    private String dept_name;
    private Date cdate;
    private Integer type;
    private String type_name;
    private Integer state;
    private String state_name;

    private List<TbStatementCharge> statementCharges;
    private List<TbStatementScheduling> statementSchedulings;
}
