package com.aaa.springcloud.mapper;

import com.aaa.pojo.plans.TbTaskAction;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface TaskActionMapper {
    //添加任务执行人
    int insertTaskAction(TbTaskAction taskAction);
    //删除任务执行人
    int delTaskAction(Long taskActionId);
    // 修改 任务执行人
    int updTaskAction(TbTaskAction taskAction);
}
