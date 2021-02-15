package com.aaa.demo.mapper;


import com.aaa.pojo.client.SearchClient;
import com.aaa.pojo.client.Tbclient;
import com.aaa.pojo.client.TbclientVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface ClientMapper {
    int insert(Tbclient tbclient);

    List<TbclientVo> selectAll(SearchClient searchClient);
    /*单独用来查询客户名称的方法*/
    List<Tbclient> selectCname();

    int del(Integer c_id);

    int update(Tbclient tbclient);

    Tbclient findByID(Integer c_id);
}
