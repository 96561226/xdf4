package com.aaa.springcloud.mapper;

import com.aaa.pojo.plans.TbStatementCharge;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface StatementChargeMapper {
    //添加计划报告人
    int insertStatementCharge(TbStatementCharge statementCharge);
    //删除计划报告人
    int delStatementCharge(Long statementChargeId);
    //修改计划报告人
    int updStatementCharge(TbStatementCharge statementCharge);
}
