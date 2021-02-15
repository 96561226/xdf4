package com.aaa.pojo.informaction;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tbdocdustbin {
    private Integer id;
    private String dname;
    private String versions;
    private String author;
    private Integer type_id;
    private String keyword;
    private Integer dept_id;
    private String project;
    private String accessory;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date updatetime;
    private String filename;
}
