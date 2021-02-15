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
public class PropertyApplyVo {

  private Long applyId;
  private String applyNo;
  private String applyName;
  private Long empId;
  private String empNo;
  private String empName;
  private Long propertyId;
  private String propertyName;
  private String propertyNo;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
  private Date applyCreateTime;
  private String remark;
  private Integer state;

  private List<PropertyApplyVo> propertyApplyVos;

  private Long ymID;

  private Integer page;
  private Integer limit;
}
