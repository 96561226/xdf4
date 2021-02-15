package com.aaa.pojo.informaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchDocDustbin {
    private Integer type_id;
    private Integer dept_id;


    private Integer page;

    private Integer limit;
}
