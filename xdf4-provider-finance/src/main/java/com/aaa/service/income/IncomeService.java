package com.aaa.service.income;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.finance.SearchIncome;
import com.aaa.pojo.finance.TbGathering;
import com.aaa.pojo.finance.TbIncome;
import com.aaa.pojo.finance.TbPaymentType;

import java.util.List;

public interface IncomeService {
    //收支登记表  方法
    //新增收支登记
    ReturnObj addIncome(TbIncome income);
    //    生成编号
    String selIncomeNo();
    //查询所有收支类型
    List<TbPaymentType> selectAllPaymentType();
    //查询所有收款类型
    List<TbGathering> selectAllGathering();
    //条件查询招聘申请表
    ReturnObj selectIncome(SearchIncome income);
}
