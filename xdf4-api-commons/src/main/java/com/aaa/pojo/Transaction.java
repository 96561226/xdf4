package com.aaa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private Long transaction_id;
    private String transaction_no;
    private String menu_name;
    private String menu_url;
    private Long parent_id;
    private String pname;
    private Integer type;
    private String remark;
    private Integer state;

    private List<Transaction> children;

}
