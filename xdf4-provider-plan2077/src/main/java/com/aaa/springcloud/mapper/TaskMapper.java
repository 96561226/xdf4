package com.aaa.springcloud.mapper;

import com.aaa.pojo.plans.TaskVo;
import com.aaa.pojo.plans.TbTask;
import com.aaa.pojo.plans.TbTaskType;
import com.aaa.searchpojo.SearchTask;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface TaskMapper {

    //添加工作任务
    int addTask(TbTask task);

    //删除工作任务
    int delTask(Long task_id);

    //修改工作任务
    int updTask(TbTask task);

    //查询工作任务
    List<TaskVo> selSeaTask(SearchTask task);

    //查询全部任务类型
    List<TbTaskType> selTaskTypes();
}
