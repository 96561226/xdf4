package com.aaa.pojo.conference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConferenceroomApproverVo {
    private Long id;
    private Long applyId;
    private Integer state;
    private Long empId;
    private String empNo;
    private String empName;
}
