package com.aaa.pojo.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchPact {
    private String pname;
    private String p_no;
    private Integer state;
    private Integer emp_id;

    private Integer page;

    private Integer limit;
}
