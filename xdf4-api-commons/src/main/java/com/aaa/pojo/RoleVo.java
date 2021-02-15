package com.aaa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleVo {
    private Long role_id;
    private String role_name;
    private String role_des;
    private Integer role_state;
    private Long dept_id;
    private String dept_name;

    private List<Transaction> transactions;

}
