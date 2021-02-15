package com.aaa.demo.service;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.client.*;

import java.util.List;

public interface PactService {
    int insert(TbPact tbPact);

    ReturnObj selectAll(SearchPact searchPact);


    int update(Integer p_id);

    TbPact findByID(Integer p_id);

    /*查询状态*/
    List<TbPactState> selState();
    /*生成合同编号*/
    String selNo();
    /*查询合同表id*/
    Integer selectEntryNo(String p_no);
    /*添加合同审批人*/
    int insertPactApprover(TbPactApprover tbPactApprover);
    /*追加售后服务*/
    int insertAfter(TbafterSale tbafterSale);

    /*修改合同状态*/
    int updatePactState(TbPactVo pact, String cname);
}
