package com.aaa.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Roles {
    private Long role_id;
    private String role_name;
    private String role_des;
    private Integer role_state;
    private Long dept_id;
    private String dept_name;
}
