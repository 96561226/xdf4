package com.aaa.mapper.income;

import com.aaa.pojo.finance.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface IncomeMapper {
    //收支表  方法
    //新增收支表记录
    int addIncome(TbIncome income);
    //生成收支表编号
    String selIncomeNo();
    //查询所有收支类型
    List<TbPaymentType> selectAllPaymentType();
    //查询所有收款类型
    List<TbGathering> selectAllGathering();
    //条件查询收支表
    List<TbIncomeVo> selectIncome(SearchIncome income);
}
