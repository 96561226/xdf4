package com.aaa.springcloud.mapper;

import com.aaa.pojo.plans.TbPlanAction;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface PlanActionMapper {
    //添加计划执行人
    int insertPlanAction(TbPlanAction planAction);
    //删除计划执行人
    int delPlanAction(Long planActionId);
    // 修改 计划执行人
    int updPlanAction(TbPlanAction planAction);
}
