package com.aaa.springcloud.mapper;

import com.aaa.pojo.conference.PurchaseApproverVo;
import com.aaa.pojo.conference.TbPurchaseApprover;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PurchaseApproverMapper {
    //查询全部的审批人
    List<PurchaseApproverVo> selPurchaseApproverAll();
    //通过审批人id修改
    int updPurchaseApprover(TbPurchaseApprover tpar);
    //添加审批人
    int addPurchaseApprover(TbPurchaseApprover tbPurchaseApprover);
}
