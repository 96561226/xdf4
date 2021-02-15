package com.aaa.demo.service;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.client.SearchAfter;
import com.aaa.pojo.client.TbAfterState;
import com.aaa.pojo.client.TbafterSale;

import java.util.List;

public interface AfterSaleService {
    ReturnObj selectAll(SearchAfter searchAfter);

    int update(Integer s_id);

    TbafterSale findByID(Integer s_id);
    /*查询状态*/
    List<TbAfterState> selState();
}
