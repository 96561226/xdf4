package com.aaa.pojo.conference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbPropertyApply {

  private Long applyId;
  private String applyNo;
  private String applyName;
  private Long empId;
  private Long propertyId;
  private Date applyCreateTime;
  private String remark;
  private Integer state;
}
