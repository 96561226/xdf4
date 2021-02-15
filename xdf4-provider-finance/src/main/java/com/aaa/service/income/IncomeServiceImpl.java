package com.aaa.service.income;

import com.aaa.mapper.income.IncomeMapper;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.finance.*;
import com.aaa.service.travelling.TravellingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IncomeServiceImpl implements IncomeService {
    @Autowired
    IncomeMapper incomeMapper;
    @Autowired
    TravellingService travellingService;
    @Override
    public ReturnObj addIncome(TbIncome income) {
        ReturnObj obj;
        income.setIncomeNo(selIncomeNo());
        int i = incomeMapper.addIncome(income);
        if (i != 0){
            obj = new ReturnObj(0,"success",i,i);
        }else {
            obj = new ReturnObj(0,"error",i,i);
        }
        return obj;
    }

    @Override
    public String selIncomeNo() {
        return incomeMapper.selIncomeNo();
    }

    @Override
    public List<TbPaymentType> selectAllPaymentType() {
        return incomeMapper.selectAllPaymentType();
    }

    @Override
    public List<TbGathering> selectAllGathering() {
        return incomeMapper.selectAllGathering();
    }

    @Override
    public ReturnObj selectIncome(SearchIncome income) {
        int currentPage = income.getPage() == null ? 1:income.getPage();
        int pageSize = income.getLimit() == null ? 3:income.getLimit();
        PageHelper.startPage(currentPage,pageSize);
        List<TbIncomeVo> bs =incomeMapper.selectIncome(income);
        PageInfo<TbIncomeVo> pageinfo = new PageInfo<TbIncomeVo>(bs);
        Integer total = Integer.valueOf(pageinfo.getTotal()+"");
        List<TbIncomeVo> list = pageinfo.getList();
        return new ReturnObj(0,"success",total,list);
    }
}
