package com.aaa.springcloud.mapper;

import com.aaa.pojo.Emp;
import com.aaa.pojo.finance.TbIncome;
import com.aaa.pojo.informaction.Tbdocument;
import com.aaa.pojo.plans.TbTask;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UtilMapper {
    //新增收支表记录
    int addIncome(TbIncome income);
    //查询员工部门
    Emp selemp(@Param("empId") Long empId);
    //查询全部的可用任务用于项目
    List<TbTask> selTask();
    //查询全部的可用文档用于项目
    List<Tbdocument> selDocument();
    //查询所有金额 用于项目
    List<TbIncome> selIncome();
}
