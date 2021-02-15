package com.aaa.springcloud.mapper;

import com.aaa.pojo.plans.TbPlanScheduling;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface PlanSchedulingMapper {
    //添加 计划事项
    int insertPlanScheduling(TbPlanScheduling tbPlanScheduling);

    //删除 计划事项
    int delPlanScheduling(Long planSId);

    //修改 计划事项
    int updPlanScheduling(TbPlanScheduling tbPlanScheduling);

    // 根据计划表ID 查询 计划事项
    List<TbPlanScheduling> selPlanSchedulingByPlanId(Long planId);
}
