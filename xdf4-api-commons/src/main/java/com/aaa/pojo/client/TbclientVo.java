package com.aaa.pojo.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbclientVo {
    private Integer c_id;
    private String cname;
    private Double predict;
    private Integer p_count;
    private Double pactmoney;
    private Double returned;
    private Integer s_count;
    private Float serve;
    private Integer type_id;
    private TbclientType type;
}
