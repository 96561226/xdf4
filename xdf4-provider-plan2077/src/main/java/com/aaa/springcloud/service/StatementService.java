package com.aaa.springcloud.service;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.plans.TbStatement;
import com.aaa.pojo.plans.TbStatementScheduling;
import com.aaa.pojo.plans.TbStatementType;
import com.aaa.searchpojo.SearchStatement;

import java.util.List;

public interface StatementService {
    ReturnObj selectStatementAll(SearchStatement statement);

    //审批报告表
    ReturnObj sqStatement(TbStatement statement, Long emp_id);

    //添加工作报告
    ReturnObj insertStatement(TbStatement statement, List<Long> cemps, List<TbStatementScheduling> schedulings);

    //修改工作报告
    int updStatement(TbStatement statement);

    //删除工作报告
    int delStatement(Long planId);

    //查询工作报告类型
    List<TbStatementType> selStatementTypes();
}
