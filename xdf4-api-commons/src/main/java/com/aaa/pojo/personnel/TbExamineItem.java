package com.aaa.pojo.personnel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TbExamineItem {

  private Long id;
  private Long assessmentLatitude;
  private String examineItem;
  private String content;
  private Long score;
  private String managersScore;


}
