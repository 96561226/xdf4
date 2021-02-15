package com.aaa.mapper;

import com.aaa.pojo.Emp;
import com.aaa.pojo.TbFormState;
import com.aaa.pojo.TbStatementState;
import com.aaa.pojo.TbTaskState;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Mapper
public interface FormMapper {

    //查询所有申请状态信息
    @Select("select * from tb_form_state")
    List<TbFormState> selStateAll();

    //查询所有任务状态信息
    @Select("select * from tb_task_state")
    List<TbTaskState> selTaskStateAll();

    //查询所有报告状态信息
    @Select("select * from tb_statement_state")
    List<TbStatementState> selStatementStateAll();

    //根据状态id查询状态名字
    @Select("select * from tb_form_state where state_id=#{state_id}")
    TbFormState selStateById(Long state_id);

    //查询添加需要的 编号
    @Select("select CONCAT(#{noName},(select right(1000000+(select max(${idName})+1 from ${tableName}),6)))")
    String selNo(@Param("noName") String noName, @Param("tableName") String tableName, @Param("idName") String idName);


    /*
    *通用查询审批人
    * dept_id指的的申请表归为的部门
    * 此通用查询可以查出 集团超管 总经办 以及对应部门和其直属上级的 经理 总监 主管
    * 方法写在了mapper.xml里
    * */
    List<Long> selApprover(@Param("dept_id") Long dept_id);


}
