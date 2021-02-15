package com.aaa.springcloud.controller;

import com.aaa.pojo.CommonResult;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.conference.*;
import com.aaa.springcloud.config.BaseController;
import com.aaa.springcloud.service.PropertyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class PropertyController extends BaseController {
    @Autowired
    PropertyService propertyService;
    //自动计算 采购 和使用 申请的调用
    @GetMapping("/property/ApproverNO")
    public List ApproverNO(){
        return propertyService.ApproverNO();
    };

    @RequestMapping("/property/proList")
    public ReturnObj selProperty(@RequestBody PropertyVo propertyVo){
        return propertyService.selProperty(propertyVo);
    }
    //为 全部资产的条件查询填充下拉
    @GetMapping("/property/selTypeAndState")
    public CommonResult selTypeAndState(){
        return propertyService.selTypeAndState();
    }
    //模糊修改资产
    @PostMapping("/property/proUpd")
    public CommonResult proUpd(@RequestBody TbProperty tbProperty){
        int i = propertyService.updPropertyToMH(tbProperty);
        if (i!=0){
            return new CommonResult(0,"修改成功",null);
        }else {
            return new CommonResult(400,"修改失败",null);
        }
    }
    @RequestMapping("/property/purList")
    public ReturnObj selPurchase(@RequestBody PurchaseVo purchaseVo){
        return propertyService.selPurchase(purchaseVo);
    }
    //采购区----
    //添加一个审批
    @PostMapping("/property/PurchaseSQ")
    public CommonResult PurchaseSQ(@RequestBody TbPurchase tbPurchase,@RequestParam("empids") Long[] empids) {
        int i = propertyService.PurchaseSQ(tbPurchase, empids);
        if (i!=0){
            return new CommonResult(0,"物品申请提交成功",null);
        }else {
            return new CommonResult(400,"未知原因提交失败，请重新尝试或联系管理员",null);
        }
    }
    //审批时
    @PostMapping("/property/PurchaseSP")
    public CommonResult PurchaseSP(@RequestBody TbPurchaseApprover tpar){
        int i = propertyService.PurchaseSP(tpar);
        if (i!=0){
            return new CommonResult(0,"审批成功",null);
        }else {
            return new CommonResult(400,"未知原因审批失败，请重新尝试或联系管理员",null);
        }
    }
    //审批完成确认采购 或者退回
    @PostMapping("/property/PurchaseCG")
    public CommonResult PurchaseCG(@RequestParam("state") Integer state,@RequestParam("purchaseId") Long purchaseId){
        int i = propertyService.PurchaseCG(state,purchaseId);
        if (i!=0){
            return new CommonResult(0,"状态修改成功",null);
        }else {
            return new CommonResult(400,"未知原因修改失败，请重新尝试或联系管理员",null);
        }
    }
    //采购完成添加
    @PostMapping("/property/PurchaseTJ")
    public CommonResult PurchaseTJ(@RequestBody TbPurchase tbPurchase){
        int i = propertyService.PurchaseTJ(tbPurchase);
        if (i!=0){
            return new CommonResult(0,"物品添加成功",null);
        }else {
            return new CommonResult(400,"未知原因添加失败，请重新尝试或联系管理员",null);
        }
    }
    //借用区
    //条件分页查询全部的借用 归还申请申请
    @RequestMapping("/property/selPropertyApplyJY")//借用申请
    public ReturnObj selPropertyApplyJY(@RequestBody PropertyApplyVo propertyApplyVo){

        return propertyService.selPropertyApply(propertyApplyVo);
    }
    @RequestMapping("/property/selPropertyApplyGH")//归还页面
    public ReturnObj selPropertyApplyGH(@RequestBody PropertyApplyVo propertyApplyVo){
        propertyApplyVo.setState(4);
        return propertyService.selPropertyApply(propertyApplyVo);
    }
    //添加一个申请
    @PostMapping("/property/addPropertyApply")
    public CommonResult PropertySQ(@RequestBody TbPropertyApply tpa,@RequestParam("empids") Long[] empids){
        int i = propertyService.PropertySQ(tpa, empids);
        if (i!=0){
            return new CommonResult(0,"物品申请成功，请等待审批",null);
        }else {
            return new CommonResult(400,"未知原因申请失败，请重新尝试或联系管理员",null);
        }
    }
    //审批时
    @PostMapping("/property/PropertySP")
    public CommonResult PropertySP(@RequestBody TbPropertyApprover tpar,@RequestParam("propertyId") Long propertyId) {
        int i = propertyService.PropertySP(tpar,propertyId);
        if (i==1){
            return new CommonResult(0,"审批成功,请通知员工及时领取！",null);
        }else if(i==2){
            return new CommonResult(0,"该物品被占用，或在维修中，审批失败！",null);
        }else if(i==3){
            return new CommonResult(0,"审批成功，已拒绝改申请！",null);
        }else {
            return new CommonResult(400,"未知原因审批失败,请重新尝试或联系管理员",null);
        }
    }
    //修改退回 确认 时
    @PostMapping("/property/PropertyXG")
    public CommonResult PropertyXG(@RequestParam("state")Integer state,@RequestParam("applyId")Long applyId) {
        int i = propertyService.PropertyXG(state, applyId);
        if (i==1){
            return new CommonResult(0,"操作成功！",null);
        }else if (i==2){
            return new CommonResult(0,"归还成功！",null);
        }else {
            return new CommonResult(400,"未知原因操作失败,请重新尝试或联系管理员！",null);
        }
    }
}
