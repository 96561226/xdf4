package com.aaa.pojo.client;

import com.aaa.pojo.Dept;
import com.aaa.pojo.Emp;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbPactVo {
    private Integer p_id;
    private String pname;
    private String p_no;
    private Double pactmoney;
    private Double returned;
    private Double billing;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date contractDate;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date endtDate;
    private Integer state;
    private String state_name;

    private Integer c_id;
    private Tbclient tbclient;

    private Integer emp_id;
    private Emp emp;

    private List<TbPactApproverVo > approverVos;

    private Integer dept_id;
    private Dept dept;

    private String details;
}
