package com.aaa.springcloud.service;

import com.aaa.pojo.CommonResult;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.conference.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

public interface PropertyService {
    //调用模糊查询 外用
    List<PropertyVo> selPropertyByMH(PropertyVo propertyVo);
    //自动计算 采购 和使用 申请的调用
    List ApproverNO();
    //查询全部资产 可分页 可条件
    ReturnObj selProperty(PropertyVo propertyVo);
    //为 全部资产的条件查询填充下拉
    CommonResult selTypeAndState();
    //模糊修改资产
    int updPropertyToMH(TbProperty tbProperty);
    //动态查询全部的财产
    ReturnObj selPurchase(PurchaseVo purchaseVo);
    //采购区----
    //添加一个审批
    int PurchaseSQ(TbPurchase tbPurchase, Long[] empids);
    //审批时
    int PurchaseSP(TbPurchaseApprover tpar);
    //审批完成确认采购 或者退回
    int PurchaseCG(Integer state, Long purchaseId);
    //采购完成添加
    int PurchaseTJ(TbPurchase tbPurchase);
    //借用区
    //条件分页查询全部的借用 归还申请申请
    ReturnObj selPropertyApply(PropertyApplyVo propertyApplyVo);
    //添加一个申请借用
    int PropertySQ(TbPropertyApply tpa, Long[] empids);
    //审批时
    int PropertySP(TbPropertyApprover tpar, Long propertyId);
    //修改退回 确认 时
    int PropertyXG(Integer state, Long applyId);
}
