package com.aaa.pojo.conference;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchApply {
    private Long empId;
    private String applyNo;
    private String applyTheme;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date applyBeginTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date applyEndTime;

    private Integer state;

    private Long conferenceRoomId;

    private Long ymID;

    private Integer page;
    private Integer limit;
}
