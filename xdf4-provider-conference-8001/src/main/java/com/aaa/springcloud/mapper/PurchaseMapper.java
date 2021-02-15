package com.aaa.springcloud.mapper;

import com.aaa.pojo.conference.PurchaseVo;
import com.aaa.pojo.conference.TbPurchase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.List;

@Mapper
@Component
public interface PurchaseMapper {
    //动态查询物品采购表
    List<PurchaseVo> selPurchaseDT(PurchaseVo purchaseVo);
    //修改 物品采购表 只能通过id修改状态
    int updPurchase(@Param("state") Integer state, @Param("purchaseBuytime") String purchaseBuytime, @Param("purchaseId") Long purchaseId);
    //添加 物品采购
    int addPurchase(TbPurchase tbPurchase);
}
