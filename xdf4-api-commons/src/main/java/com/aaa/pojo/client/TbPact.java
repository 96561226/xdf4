package com.aaa.pojo.client;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbPact {
    private Integer p_id;
    private String pname;
    private String p_no;
    private Double pactmoney;
    private Double returned;
    private Double billing;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date contractDate;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date endtDate;
    private Integer state;
    private Integer c_id;
    private Integer emp_id;
    private Integer dept_id;
    private String details;

    public TbPact(TbPactVo pactVo){
        this.p_id = pactVo.getP_id();
        this.pname = pactVo.getPname();
        this.p_no = pactVo.getP_no();
        this.pactmoney = pactVo.getPactmoney();
        this.returned = pactVo.getReturned();
        this.billing = pactVo.getBilling();
        this.contractDate = pactVo.getContractDate();
        this.endtDate = pactVo.getEndtDate();
        this.state = pactVo.getState();
        this.c_id = pactVo.getC_id();
        this.emp_id = pactVo.getEmp_id();
        this.dept_id = pactVo.getDept_id();
        this.details = pactVo.getDetails();
    }
}
