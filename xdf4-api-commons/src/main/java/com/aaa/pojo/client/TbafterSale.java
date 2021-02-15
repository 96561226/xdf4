package com.aaa.pojo.client;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbafterSale {
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
    private String content;
    private String feedback;
    private Integer typeid;
    private Integer emp_id;
    private Integer c_id;
    private Integer dept_id;
    private Integer p_id;
}
