package com.aaa.springcloud.mapper;

import com.aaa.pojo.plans.TbPlanScheduling;
import com.aaa.pojo.plans.TbTaskScheduling;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface TaskSchedulingMapper {
    //添加 任务事项
    int insertTaskScheduling(TbTaskScheduling tbTaskScheduling);

    //删除 任务事项
    int delTaskScheduling(Long taskSId);

    //修改 任务事项
    int updTaskScheduling(TbTaskScheduling tbTaskScheduling);

    // 根据任务表ID 查询 任务事项
    List<TbTaskScheduling> selTaskSchedulingByTaskId(Long taskId);
}
