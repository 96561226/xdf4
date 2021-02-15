package com.aaa.pojo.plans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanVo {
    private Long plan_id;
    private String plan_no;
    private String title;
    private Long emp_id;
    private String emp_name;
    private Long dept_id;
    private String dept_name;
    private Long parent_id;
    private String pname;
    private Date cdate;
    private Date sdate;
    private Date edate;
    private Integer type;
    private String type_name;
    private Integer state;
    private String fstate_name;
    private List<TbPlanAction> planActions;
    private List<TbPlanCharge> planCharges;
    private List<TbPlanScheduling> planSchedulings;
}
