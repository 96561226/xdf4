package com.aaa.demo.mapper;

import com.aaa.pojo.client.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface PactMapper {
    int insert(TbPact tbPact);

    List<TbPactVo> selectAll(SearchPact searchPact);

    int update(Integer p_id);

    TbPact findByID(Integer p_id);

    /*查询状态*/
    List<TbPactState> selState();
    /*生成合同编号*/
    String selNo();
    /*添加合同审批人*/
    int insertPactApprover(TbPactApprover tbPactApprover);
    /*合同数加一*/
    int addPactCount(TbPact pact);
    /*售后服务数加一*/
    int addAfterCount(TbafterSale tbafterSale);
    /*追加售后服务*/
    int insertAfter(TbafterSale tbafterSale);

    /*修改合同状态*/
    int updatePactState(TbPact pact);
}
