package com.aaa.pojo.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchAfter {
    private String theme;
    private Integer typeid;
    private Integer state;

    private Integer page;

    private Integer limit;
}
