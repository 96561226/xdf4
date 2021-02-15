package com.aaa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptVo {
    private Long dept_id;
    private String dept_no;
    private String dept_name;
    private Long parent_id;
    private String pname;
    private String dept_loc;
    private Integer type;
    private String remark;
    private Integer state;

    private List<DeptVo> children;

    private List<EmpVo> emps;
    private List<Roles> roles;

}
