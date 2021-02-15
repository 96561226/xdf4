package com.aaa.pojo.informaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tbinlinkman {
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
}
