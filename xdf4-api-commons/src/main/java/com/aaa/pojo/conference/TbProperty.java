package com.aaa.pojo.conference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TbProperty {

  private Long propertyId;
  private String propertyNo;
  private String propertyName;
  private Date propertyBuytime;
  private String propertyManufacturer;
  private Integer propertyUnivalence;
  private String propertyPlace;
  private Integer propertyState;
  private Long typeId;
  private Long stateId;
}
