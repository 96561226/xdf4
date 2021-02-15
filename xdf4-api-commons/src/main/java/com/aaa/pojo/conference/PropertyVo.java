package com.aaa.pojo.conference;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PropertyVo {
  private Long propertyId;
  private String propertyNo;
  private String propertyName;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
  private Date propertyBuytime;
  private String propertyManufacturer;
  private Integer propertyUnivalence;
  private String propertyPlace;
  private Integer propertyState;
  private Long typeId;
  private Long stateId;

  private String stateName;

  private String typeName;

  private Integer page;
  private Integer limit;
}
