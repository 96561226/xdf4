package com.aaa.springcloud.mapper;

import com.aaa.pojo.plans.TbStatementScheduling;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface StatementSchedulingMapper {
    //添加 报告事项
    int insertStatementScheduling(TbStatementScheduling statementScheduling);

    //删除 报告事项
    int delStatementScheduling(Long statementSId);

    //修改 报告事项
    int updStatementScheduling(TbStatementScheduling statementScheduling);

    // 根据报告表ID 查询 报告事项
    List<TbStatementScheduling> selStatementSchedulingByStatementId(Long statementId);
}
