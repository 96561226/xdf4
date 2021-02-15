package com.aaa.demo.service;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.client.SearchClient;
import com.aaa.pojo.client.Tbclient;

import java.util.List;


public interface ClientService {
    int insert(Tbclient tbclient);

    ReturnObj selectAll(SearchClient searchClient);
    /*单独用来查询客户名称的方法*/
    List<Tbclient> selectCname();

    int del(Integer c_id);

    int update(Tbclient tbclient);

    Tbclient findByID(Integer c_id);

    //批量删除
    boolean delAll(Integer[] ids);
}
