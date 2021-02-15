package com.aaa.springcloud.mapper;


import com.aaa.pojo.plans.TbPlanType;
import com.aaa.searchpojo.SearchPlan;
import com.aaa.pojo.plans.PlanVo;
import com.aaa.pojo.plans.TbPlan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface PlanMapper {
    //添加工作计划
    int insertPlan(TbPlan plan);

    //修改工作计划
    int updPlan(TbPlan plan);

    //删除工作计划
    int delPlan(Long planId);

    //查询全部工作计划
    List<PlanVo> selPlanAll(SearchPlan searchPlan);

    //查询工作计划类型
    List<TbPlanType> selPlanTypes();












}
