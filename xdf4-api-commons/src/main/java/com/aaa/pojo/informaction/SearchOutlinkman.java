package com.aaa.pojo.informaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchOutlinkman {
    private Integer id;
    private String linkname;
    private String title;
    private String institution;
    private String gphone;
    private String yphone;
    private Integer typeid;

    private Integer page;

    private Integer limit;
}
