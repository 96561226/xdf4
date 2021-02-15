package com.aaa.demo.service;


import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.informaction.SearchOutlinkman;
import com.aaa.pojo.informaction.Tboutlinkman;

import java.util.List;

public interface OutLinkmanService {
    int insert(Tboutlinkman tboutlinkman);

    ReturnObj selectAll(SearchOutlinkman outlinkman);

    int del(Integer id);

    int update(Tboutlinkman tboutlinkman);

    Tboutlinkman findByID(Integer id);

    //批量删除
    boolean delAll(Integer[] ids);
}
