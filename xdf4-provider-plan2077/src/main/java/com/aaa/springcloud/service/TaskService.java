package com.aaa.springcloud.service;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.plans.*;
import com.aaa.searchpojo.SearchPlan;
import com.aaa.searchpojo.SearchTask;

import java.util.List;

public interface TaskService {
    ReturnObj selectTaskAll(SearchTask task);

    //审批任务表
    ReturnObj sqTask(TbTask task, Long emp_id);

    //添加工作任务
    ReturnObj insertTask(TbTask task, List<Long> aemps, List<TbTaskScheduling> schedulings);

    //修改工作任务
    int updTask(TbTask task);

    //删除工作任务
    ReturnObj delTask(Long taskId);

    //查询工作任务类型
    List<TbTaskType> selTaskTypes();
}
