package com.aaa.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    private Long emp_id;
    private String emp_no;
    private String emp_name;
    private Long role_id;
    private Long mgr;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date hiredate;
    private Double sal;
    private Double comm;
    private Long dept_id;
    private String pwd;
    private Integer state;
}
