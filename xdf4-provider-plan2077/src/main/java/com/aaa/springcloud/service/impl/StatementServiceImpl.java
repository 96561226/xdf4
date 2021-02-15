package com.aaa.springcloud.service.impl;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.plans.*;
import com.aaa.searchpojo.SearchStatement;
import com.aaa.springcloud.mapper.StatementChargeMapper;
import com.aaa.springcloud.mapper.StatementMapper;
import com.aaa.springcloud.mapper.StatementSchedulingMapper;
import com.aaa.springcloud.service.StatementService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StatementServiceImpl implements StatementService {
    @Autowired
    StatementMapper statementMapper;
    @Autowired
    StatementChargeMapper chargeMapper;
    @Autowired
    StatementSchedulingMapper schedulingMapper;

    @Override
    public ReturnObj selectStatementAll(SearchStatement statement) {
        List<StatementVo> svs =statementMapper.selStatementAll(statement);
        return new ReturnObj(0,"",svs.size(),svs);
    }

    @Override
    public ReturnObj sqStatement(TbStatement statement, Long emp_id) {
        int i = statementMapper.updStatement(statement);
        if (i==0){
            return new ReturnObj(400,"审批报告失败",i,null);
        }
        //修改审批人状态
        TbStatementCharge tbStatementCharge = new TbStatementCharge();

        tbStatementCharge.setCharge_emp_id(emp_id);
        tbStatementCharge.setSid(statement.getStatement_id());
        tbStatementCharge.setState(2);

        int j = chargeMapper.updStatementCharge(tbStatementCharge);
        if (j==0){
            return new ReturnObj(400,"审批人状态异常",i,null);
        }

        return new ReturnObj(200,"审批完成",i,i);
    }

    @Override
    public ReturnObj insertStatement(TbStatement statement, List<Long> cemps, List<TbStatementScheduling> schedulings) {
        //验证信息是否完整
        if (null==statement){
            return new ReturnObj(400,"工作报告状态异常",null,null);
        }
        if (null==cemps || cemps.size()==0){
            return new ReturnObj(400,"审批责任人信息状态异常",null,null);
        }

        //添加
        int i = statementMapper.insertStatement(statement);
        if (i==0){
            return new ReturnObj(400,"提交报告失败",null,null);
        }
        //验证是否添加成功
        SearchStatement searchStatement = new SearchStatement();
        searchStatement.setStatement_no(statement.getStatement_no());
        List<StatementVo> statementVos = statementMapper.selStatementAll(searchStatement);
        if (null==statementVos || statementVos.size()==0){
            return new ReturnObj(400,"添加成功，查询异常",null,null);
        }
        //取出刚添加的计划
        StatementVo statementVo=statementVos.get(0);
        Long statement_id = statementVo.getStatement_id();

        //添加责任人
        for (Long cemp : cemps) {
            TbStatementCharge charge = new TbStatementCharge();
            charge.setSid(statement_id);
            charge.setCharge_emp_id(cemp);
            int j = chargeMapper.insertStatementCharge(charge);
            if (j==0){
                return new ReturnObj(400,"添加审批责任人失败",null,null);
            }
        }
        //添加计划事项

        for (TbStatementScheduling scheduling : schedulings) {
            scheduling.setSid(statement_id);
            int j = schedulingMapper.insertStatementScheduling(scheduling);
            if (j==0){
                return new ReturnObj(400,"添加报告事项失败",null,null);
            }
        }

        return new ReturnObj(200,"一切OK",0,"success");
    }

    @Override
    public int updStatement(TbStatement statement) {
        return statementMapper.updStatement(statement);
    }

    @Override
    public int delStatement(Long planId) {
        return statementMapper.delStatement(planId);
    }

    @Override
    public List<TbStatementType> selStatementTypes() {
        return statementMapper.selStatementTypes();
    }
}
