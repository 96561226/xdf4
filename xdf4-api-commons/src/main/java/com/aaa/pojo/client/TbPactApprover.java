package com.aaa.pojo.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbPactApprover {
    private Integer id;
    private Integer p_id;
    private Integer emp_id;
    private Integer state;

    public TbPactApprover (Integer p_id,Integer emp_id){
        this.p_id=p_id;
        this.emp_id=emp_id;
    }
}
