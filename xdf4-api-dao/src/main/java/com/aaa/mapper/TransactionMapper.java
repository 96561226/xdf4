package com.aaa.mapper;

import com.aaa.pojo.Transaction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface TransactionMapper {
    //添加
    int insert(Transaction record);

    //删除
    int delTrasaction(Long tid);

    //修改
    int updTrasaction(Transaction transaction);

    //查询全部资源
    List<Transaction> selectAll();

    //根据登录工号查找到该用户对应的功能
    List<Transaction> selectByLoginNo(String empNo);

    //根据角色查找所有的资源
    List<Transaction> selectByRoleId(Long role_id);

}
