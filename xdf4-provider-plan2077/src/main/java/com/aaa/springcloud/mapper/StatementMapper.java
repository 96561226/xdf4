package com.aaa.springcloud.mapper;

import com.aaa.pojo.plans.*;
import com.aaa.searchpojo.SearchPlan;
import com.aaa.searchpojo.SearchStatement;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface StatementMapper {
    //添加工作报告
    int insertStatement(TbStatement statement);

    //修改工作报告
    int updStatement(TbStatement statement);

    //删除工作报告
    int delStatement(Long statementId);

    //查询全部工作报告
    List<StatementVo> selStatementAll(SearchStatement searchStatement);

    //查询工作报告类型
    List<TbStatementType> selStatementTypes();
}
