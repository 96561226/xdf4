package com.aaa.pojo.conference;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConferenceroomApplyVo {
    private Long applyId;
    private String applyNo;
    private String applyTheme;
    private Long conferenceRoomId;
    private String conferenceRoomName;
    private Long empId;
    private String empNo;
    private String empName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date applyCreateTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date applyBeginTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date applyEndTime;
    private String remark;
    private Integer state;
    private List<ConferenceroomApproverVo> conferenceroomApproverVo;

    private Integer page;
    private Integer limit;
}
