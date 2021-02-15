package com.aaa.springcloud.mapper;

import com.aaa.pojo.plans.TbPlanCharge;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface PlanChargeMapper {
    //添加计划责任人
    int insertPlanCharge(TbPlanCharge planCharge);
    //删除计划责任人
    int delPlanCharge(Long planChargeId);
    //修改计划责任人
    int updPlanCharge(TbPlanCharge planCharge);

}
