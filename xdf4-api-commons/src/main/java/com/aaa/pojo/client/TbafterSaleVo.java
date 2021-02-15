package com.aaa.pojo.client;

import com.aaa.pojo.Dept;
import com.aaa.pojo.Emp;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbafterSaleVo {
    private Integer s_id;
    private String theme;
    private String ojname;
    private String gphone;
    private String yphone;
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
    private Integer state;
    private String state_name;
    private String content;
    private String feedback;

    private Integer typeid;
    private TbafterType type;

    private Integer emp_id;
    private Emp emp;

    private Integer c_id;
    private Tbclient tbclient;

    private Integer dept_id;
    private Dept dept;

    private Integer p_id;
    private TbPact pact;
}
