package com.aaa.springcloud.service.conference;

import com.aaa.pojo.CommonResult;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.conference.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(value = "XDF4-PROVIDER-CONFERENCE",contextId="property")
public interface PropertyService {
    //自动计算 采购 和使用 申请的调用
    @GetMapping("/property/ApproverNO")
    public List ApproverNO();
    //查询全部资产 可分页 可条件
    @RequestMapping("/property/proList")
    public ReturnObj selProperty(@RequestBody PropertyVo propertyVo);

    //为 全部资产的条件查询填充下拉
    @GetMapping("/property/selTypeAndState")
    public CommonResult selTypeAndState();

    //模糊修改资产
    @PostMapping("/property/proUpd")
    public CommonResult proUpd(@RequestBody TbProperty tbProperty);

    //查询采购情况
    @RequestMapping("/property/purList")
    public ReturnObj selPurchase(@RequestBody PurchaseVo purchaseVo);

    //采购区----
    //添加审批
    @PostMapping("/property/PurchaseSQ")
    public CommonResult PurchaseSQ(@RequestBody TbPurchase tbPurchase, @RequestParam("empids") Long[] empids);
    //审批时
    @PostMapping("/property/PurchaseSP")
    public CommonResult PurchaseSP(@RequestBody TbPurchaseApprover tpar);

    //审批完成确认采购 或者退回
    @PostMapping("/property/PurchaseCG")
    public CommonResult PurchaseCG(@RequestParam("state") Integer state, @RequestParam("purchaseId") Long purchaseId);

    //采购完成添加
    @PostMapping("/property/PurchaseTJ")
    public CommonResult PurchaseTJ(@RequestBody TbPurchase tbPurchase);

    //借用区
    //条件分页查询全部的借用 归还申请申请
    @RequestMapping("/property/selPropertyApplyJY")//借用申请
    public ReturnObj selPropertyApplyJY(@RequestBody PropertyApplyVo propertyApplyVo);

    @RequestMapping("/property/selPropertyApplyGH")//归还
    public ReturnObj selPropertyApplyGH(@RequestBody PropertyApplyVo propertyApplyVo);
    //添加一个物品借用
    @PostMapping("/property/addPropertyApply")
    public CommonResult PropertySQ(@RequestBody TbPropertyApply tpa, @RequestParam("empids") Long[] empids);
    //审批时
    @PostMapping("/property/PropertySP")
    public CommonResult PropertySP(@RequestBody TbPropertyApprover tpar, @RequestParam("propertyId") Long propertyId);
    //修改退回 确认 时
    @PostMapping("/property/PropertyXG")
    public CommonResult PropertyXG(@RequestParam("state") Integer state, @RequestParam("applyId") Long applyId);
}
