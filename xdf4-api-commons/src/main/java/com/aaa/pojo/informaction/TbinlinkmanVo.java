package com.aaa.pojo.informaction;

import com.aaa.pojo.Dept;
import com.aaa.pojo.Emp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbinlinkmanVo {
    private Integer id;
    private String pic;
    private Integer emp_id;
    private String signature;
    private Integer dept_id;
    private String gphone;
    private String yphone;
    private String email;
    private String urgent;
    private String im;
    private String dept_name;
    private Emp emp;
}
