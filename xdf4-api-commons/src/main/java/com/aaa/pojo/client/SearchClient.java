package com.aaa.pojo.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchClient {
    private String cname;
    private Integer type_id;

    private Integer page;

    private Integer limit;
}
