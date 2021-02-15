package com.aaa.demo.service;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.informaction.SearchInlinkman;
import com.aaa.pojo.informaction.Tbinlinkman;

public interface InLinkmanService {
    int insert(Tbinlinkman tbinlinkman);

    ReturnObj selectAll(SearchInlinkman inlinkman);

    int del(Integer id);

    int update(Tbinlinkman tbinlinkman);

    Tbinlinkman findByID(Tbinlinkman tbinlinkman);


    //批量删除
    boolean delAll(Integer[] ids);
}
