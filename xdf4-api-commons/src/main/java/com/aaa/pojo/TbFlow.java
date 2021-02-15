package com.aaa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbFlow {
    private Long flow_id;
    private String flow_no;
    private String flow_name;
    private Long parent_id;
    private String flow_url;
    private String remark;
}
