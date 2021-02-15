package com.aaa.springcloud.controller.conference;

import com.aaa.pojo.CommonResult;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.conference.*;
import com.aaa.springcloud.service.conference.PropertyService;
import com.aaa.springcloud.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PropertyController extends BaseController {
    @Autowired
    PropertyService propertyService;
    //自动计算 采购 和使用 申请的调用
    @GetMapping("/property/ApproverNO")
    public List ApproverNO(){
        return propertyService.ApproverNO();
    }
    @RequestMapping("/property/proList")
    public ReturnObj selProperty(PropertyVo propertyVo){
       return propertyService.selProperty(propertyVo);
    }
    //为 全部资产的条件查询填充下拉
    @GetMapping("/property/selTypeAndState")
    public CommonResult selTypeAndState(){
        return propertyService.selTypeAndState();
    }
    //网页权限验证
    @GetMapping("/property/yanzheng")
    public CommonResult yz(){
        Authentication au = SecurityContextHolder.getContext().getAuthentication();
        Object[] array = au.getAuthorities().toArray();
        String role = array[2].toString();
        System.out.println(array);
        int i=0;
        switch (role){
            case "ROLE_master": i=1 ;break;
            case "ROLE_行政经理": i=1 ;break;
        }
        if (i==1){
            return new CommonResult(0,"权限足够",null);
        }else {
            return new CommonResult(400,"权限不够啊亲",null);
        }
    }
    @PostMapping("/property/proUpd")
    public CommonResult proUpd(TbProperty tbProperty){
        return propertyService.proUpd(tbProperty);
    };
    //查询采购情况
    @RequestMapping("/property/purList")
    public ReturnObj selPurchase(PurchaseVo purchaseVo){
        return propertyService.selPurchase(purchaseVo);
    }
    //采购区----
    //添加一个审批
    @PostMapping("/property/PurchaseSQ")
    public CommonResult PurchaseSQ(TbPurchase tbPurchase,Long[] empids){
        return propertyService.PurchaseSQ(tbPurchase,empids);
    }
    //审批时
    @PostMapping("/property/PurchaseSP")
    public CommonResult PurchaseSP(TbPurchaseApprover tpar){
        return propertyService.PurchaseSP(tpar);
    }

    //审批完成确认采购 或者退回
    @PostMapping("/property/PurchaseCG")
    public CommonResult PurchaseCG(Integer state,Long purchaseId){
        return propertyService.PurchaseCG(state,purchaseId);
    }

    //采购完成添加
    @PostMapping("/property/PurchaseTJ")
    public CommonResult PurchaseTJ(TbPurchase tbPurchase){
        return propertyService.PurchaseTJ(tbPurchase);
    }
    //借用区
    //条件分页查询全部的借用 归还申请申请
    @RequestMapping("/property/selPropertyApplyJY")//借用申请
    public ReturnObj selPropertyApplyJY(PropertyApplyVo propertyApplyVo){
        return propertyService.selPropertyApplyJY(propertyApplyVo);
    }

    @RequestMapping("/property/selPropertyApplyGH")//归还申请
    public ReturnObj selPropertyApplyGH(PropertyApplyVo propertyApplyVo){
        return propertyService.selPropertyApplyGH(propertyApplyVo);
    }
    //添加一个物品借用
    @PostMapping("/property/addPropertyApply")
    public CommonResult PropertySQ(TbPropertyApply tpa,Long[] empids){
        return propertyService.PropertySQ(tpa, empids);
    }
    //审批时
    @PostMapping("/property/PropertySP")
    public CommonResult PropertySP(TbPropertyApprover tpar,Long propertyId){
        return propertyService.PropertySP(tpar,propertyId);
    }
    //修改退回 确认 时
    @PostMapping("/property/PropertyXG")
    public CommonResult PropertyXG(Integer state,Long applyId){
        return propertyService.PropertyXG(state,applyId);
    }
}
