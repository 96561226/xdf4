package com.aaa.pojo.informaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchDocument {
    private Integer id;
    private String dname;
    private String versions;
    private String author;
    private Integer type_id;
    private String keyword;
    private Integer dept_id;
    private String project;
    private String accessory;
    private Date updatetime;

    private Integer page;

    private Integer limit;
}
