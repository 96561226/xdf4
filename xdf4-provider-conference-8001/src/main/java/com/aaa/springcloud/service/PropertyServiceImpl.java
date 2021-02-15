package com.aaa.springcloud.service;

import com.aaa.pojo.CommonResult;
import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.conference.*;
import com.aaa.pojo.finance.TbIncome;
import com.aaa.springcloud.mapper.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    //外置接口调用
    @Resource
    WZService wzService;
    @Autowired
    UtilMapper utilMapper;
    //内部调用
    @Autowired
    PropertyMapper propertyMapper;
    @Autowired
    PurchaseMapper purchaseMapper;
    @Autowired
    PurchaseApproverMapper purchaseApproverMapper;
    @Autowired
    PropertyApplyMapper propertyApplyMapper;
    @Autowired
    PropertyApproverMapper propertyApproverMapper;
    //模糊查询资产 外用 不分页 11
    @Override
    public List<PropertyVo> selPropertyByMH(PropertyVo propertyVo) {
        return propertyMapper.selPropertyByMH(propertyVo);
    }

    //自动计算 采购 和使用 申请的调用
    @Override
    public List ApproverNO() {
        List list=new ArrayList();
        ReturnObj CGSQ = wzService.selno("CG-", "tb_purchase", "purchase_id");
        ReturnObj JYSQ = wzService.selno("JYSQ-", "tb_property_apply", "apply_id");
        list.add(CGSQ.getData().toString());
        list.add(JYSQ.getData().toString());
        return list;
    }

    //查询全部资产 可分页 可条件
    @Override
    public ReturnObj selProperty(PropertyVo propertyVo) {
        int currentPage = propertyVo.getPage() == null ? 1:propertyVo.getPage();
        int pageSize = propertyVo.getLimit() == null ? 5:propertyVo.getLimit();
        PageHelper.startPage(currentPage,pageSize);
        List<PropertyVo> propertyVos = propertyMapper.selPropertyByMH(propertyVo);
        PageInfo<PropertyVo> pageinfo = new PageInfo<PropertyVo>(propertyVos);
        Integer total = Integer.valueOf(pageinfo.getTotal()+"");
        List<PropertyVo> list = pageinfo.getList();
        return new ReturnObj(0,"",total,list);
    }
    //为 全部资产的条件查询填充下拉
    @Override
    public CommonResult selTypeAndState() {
        List<TbPropertyType> tbPropertyTypes = propertyMapper.selType();
        List<TbPropertyState> tbPropertyStates = propertyMapper.selState();
        List list=new ArrayList();
        list.add(tbPropertyTypes);
        list.add(tbPropertyStates);
        return new CommonResult(0,"",list);
    }
    //模糊修改资产
    @Override
    public int updPropertyToMH(TbProperty tbProperty) {
        return propertyMapper.updPropertyToMH(tbProperty);
    }

    @Override
    public ReturnObj selPurchase(PurchaseVo purchaseVo) {
        int currentPage = purchaseVo.getPage() == null ? 1:purchaseVo.getPage();
        int pageSize = purchaseVo.getLimit() == null ? 5:purchaseVo.getLimit();
        PageHelper.startPage(currentPage,pageSize);
        List<PurchaseVo> purchaseVos = purchaseMapper.selPurchaseDT(purchaseVo);
        PageInfo<PurchaseVo> pageinfo = new PageInfo<PurchaseVo>(purchaseVos);
        Integer total = Integer.valueOf(pageinfo.getTotal()+"");
        List<PurchaseVo> list = pageinfo.getList();
        return new ReturnObj(0,"",total,list);
    }
    //采购区----
    //添加一个审批
    @Override
    public int PurchaseSQ(TbPurchase tbPurchase, Long[] empids) {
        //添加审批表
        tbPurchase.setState(1);
        int res1 = purchaseMapper.addPurchase(tbPurchase);
        //查出刚添加的id
        PurchaseVo purchaseVo=new PurchaseVo();
        purchaseVo.setPurchaseNo(tbPurchase.getPurchaseNo());
        List<PurchaseVo> purchaseVos = purchaseMapper.selPurchaseDT(purchaseVo);
        //添加审批人
        TbPurchaseApprover tbPurchaseApprover=new TbPurchaseApprover();
        tbPurchaseApprover.setPurchaseId(purchaseVos.get(0).getPurchaseId());
        tbPurchaseApprover.setRemark(null);
        tbPurchaseApprover.setState(1);
        int res2 =0;
        for (Long i: empids) {
            tbPurchaseApprover.setEmpId(i);
            int res3= purchaseApproverMapper.addPurchaseApprover(tbPurchaseApprover);
            if (res3!=0){
                res2++;
            }
        }
        if (res1!=0&&res2==empids.length){
            return 1;
        }
        return 0;
    }

    //审批时
    @Override
    public int PurchaseSP(TbPurchaseApprover tpar) {
        int res1=purchaseMapper.updPurchase(tpar.getState(),null,tpar.getPurchaseId());
        int res2=purchaseApproverMapper.updPurchaseApprover(tpar);
        if (res1!=0&res2!=0){//上面流程跑完 开始添加财务
            if (tpar.getState()==3){//同意审批完成添加财务
                //查询编号
                ReturnObj SZ = wzService.selno("SZ-", "tb_income", "income_id");
                //通过采购编号查询所有采购信息
                PurchaseVo purchaseVo=new PurchaseVo();
                purchaseVo.setPurchaseId(tpar.getPurchaseId());
                List<PurchaseVo> purchaseVos = purchaseMapper.selPurchaseDT(purchaseVo);
                PurchaseVo purchase=purchaseVos.get(0);
                System.out.println("purchase"+purchase);
                //查询员工部门
                Emp selemp = utilMapper.selemp(purchase.getEmpId());
                //设置财务添加内容
                TbIncome tbIncome=new TbIncome();
                tbIncome.setIncomeNo(SZ.getData().toString());
                tbIncome.setInvolveType((long)3);
                tbIncome.setMoney((double)purchase.getPurchaseUnivalence());
                tbIncome.setRegister(tpar.getEmpId());
                tbIncome.setEmpId(purchase.getEmpId());
                tbIncome.setDeptId(selemp.getDept_id());
                tbIncome.setUnits(purchase.getPurchaseManufacturer());
                tbIncome.setIncomeDeclare(purchase.getRemark());
                tbIncome.setState((long)2);
                System.out.println("tbINcome"+tbIncome);
                int i = utilMapper.addIncome(tbIncome);
            }
            return 1;
        }
        return 0;
    }
    //审批完成确认采购 或者退回
    @Override
    public int PurchaseCG(Integer state, Long purchaseId) {
        //格式化时间
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd");
        int i=0;
        if (state==4){
             i = purchaseMapper.updPurchase(state,temp.format(new Date()),purchaseId);
        }else {
             i = purchaseMapper.updPurchase(state, null,purchaseId);
        }
        if (i!=0){
            return 1;
        }
        return 0;
    }
    //采购完成添加
    @Override
    public int PurchaseTJ(TbPurchase tbPurchase) {
        int res1 = purchaseMapper.updPurchase(5,null,tbPurchase.getPurchaseId());
        //自动查询编号
        ReturnObj selno = wzService.selno("ZC-", "tb_property", "property_id");
        //把采购表的信息塞到 物品表里实现添加
        TbProperty tpy=new TbProperty();
        tpy.setPropertyNo(selno.getData().toString());
        tpy.setPropertyName(tbPurchase.getPurchaseName());
        tpy.setPropertyBuytime(tbPurchase.getPurchaseBuytime());
        tpy.setPropertyManufacturer(tbPurchase.getPurchaseManufacturer());
        tpy.setPropertyUnivalence(tbPurchase.getPurchaseUnivalence());
        tpy.setPropertyPlace(tbPurchase.getPurchasePlace());
        tpy.setPropertyState(tbPurchase.getPurchaseState());
        tpy.setTypeId(tbPurchase.getTypeId());
        tpy.setStateId((long)2);
        int res2 = propertyMapper.addProperty(tpy);
        if (res1!=0&res2!=0){
            return 1;
        }
        return 0;
    }
    //借用区
    //条件分页查询全部的借用 归还申请申请
    @Override
    public ReturnObj selPropertyApply(PropertyApplyVo propertyApplyVo) {
        int currentPage = propertyApplyVo.getPage() == null ? 1:propertyApplyVo.getPage();
        int pageSize = propertyApplyVo.getLimit() == null ? 5:propertyApplyVo.getLimit();
        PageHelper.startPage(currentPage,pageSize);
        List<PropertyApplyVo> propertyApplyVos = propertyApplyMapper.selPropertyApplyByDT(propertyApplyVo);
        PageInfo<PropertyApplyVo> pageinfo = new PageInfo<PropertyApplyVo>(propertyApplyVos);
        Integer total = Integer.valueOf(pageinfo.getTotal()+"");
        List<PropertyApplyVo> list = pageinfo.getList();
        return new ReturnObj(0,"",total,list);
    }
    //添加一个审批
    @Override
    public int PropertySQ(TbPropertyApply tpa, Long[] empids) {
        //添加审批表
        tpa.setState(1);
        int res1 = propertyApplyMapper.addPropertyApply(tpa);
        //查出刚添加的id
        PropertyApplyVo propertyApplyVo=new PropertyApplyVo();
        propertyApplyVo.setApplyNo(tpa.getApplyNo());
        List<PropertyApplyVo> propertyApplyVos = propertyApplyMapper.selPropertyApplyByDT(propertyApplyVo);
        //添加审批人
        TbPropertyApprover tbPropertyApprover=new TbPropertyApprover();
        tbPropertyApprover.setApplyId(propertyApplyVos.get(0).getApplyId());
        tbPropertyApprover.setRemark(null);
        tbPropertyApprover.setState(1);
        int res2 =0;
        for (Long i: empids) {
            tbPropertyApprover.setEmpId(i);
            int res3 = propertyApproverMapper.addPropertyApprover(tbPropertyApprover);
            if (res3!=0){
                res2++;
            }
        }
        if (res1!=0&&res2==empids.length){
            return 1;
        }
        return 0;
    }
    //审批时
    @Override
    public int PropertySP(TbPropertyApprover tpar, Long propertyId) {
        //先判断时同意还是失败
        if (tpar.getState()==3){
            /*先判断该物品是否被占用*/
            PropertyVo propertyVo=new PropertyVo();
            propertyVo.setPropertyId(propertyId);
            List<PropertyVo> propertyVos = propertyMapper.selPropertyByMH(propertyVo);
            if (propertyVos.get(0).getStateId() == (long) 2){
                //修改物品状态
                TbProperty tbProperty=new TbProperty();
                tbProperty.setPropertyId(propertyId);
                tbProperty.setStateId((long)1);
                int res3 = propertyMapper.updPropertyToMH(tbProperty);
                //修改审批等状态
                int res1 = propertyApplyMapper.updPropertyApply(tpar.getState(), tpar.getApplyId());
                int res2 = propertyApproverMapper.updPropertyApprover(tpar);
                if (res1!=0&&res2!=0&&res3!=0){
                    return 1;
                }
            }else {
                int res1 = propertyApplyMapper.updPropertyApply(7, tpar.getApplyId());
                int res2 = propertyApproverMapper.updPropertyApprover(tpar);
                if (res1!=0&&res2!=0){
                    return 2;
                }
            }
        }else {
            int res1 = propertyApplyMapper.updPropertyApply(tpar.getState(), tpar.getApplyId());
            int res2 = propertyApproverMapper.updPropertyApprover(tpar);
            if (res1!=0&&res2!=0){
                return 3;
            }
        }
        return 0;
    }
    //修改退回 确认 时
    @Override
    public int PropertyXG(Integer state, Long applyId) {
        if (state==5){//修改状态
            //通过applyid物品id
            PropertyApplyVo propertyApplyVo=new PropertyApplyVo();
            propertyApplyVo.setApplyId(applyId);
            List<PropertyApplyVo> propertyApplyVos = propertyApplyMapper.selPropertyApplyByDT(propertyApplyVo);
            //通过物品id修改物品状态
            TbProperty tbProperty=new TbProperty();
            tbProperty.setPropertyId(propertyApplyVos.get(0).getPropertyId());
            tbProperty.setStateId((long)2);
            int res1 = propertyMapper.updPropertyToMH(tbProperty);
            int res2 = propertyApplyMapper.updPropertyApply(state,applyId);
            if (res1!=0&&res2!=0){
                return 2;
            }
        }else {
            int res1 = propertyApplyMapper.updPropertyApply(state,applyId);
            if (res1!=0){
                return 1;
            }
        }

        return 0;
    }

}
