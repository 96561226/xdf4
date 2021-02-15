package com.aaa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {
    private Long dept_id;
    private String dept_no;
    private String dept_name;
    private Long parent_id;
    private String dept_loc;
    private Integer type;
    private String remark;
    private Integer state;
}
