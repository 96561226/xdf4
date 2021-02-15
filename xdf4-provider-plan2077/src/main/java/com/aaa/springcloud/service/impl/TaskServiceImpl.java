package com.aaa.springcloud.service.impl;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.plans.*;
import com.aaa.searchpojo.SearchTask;
import com.aaa.springcloud.mapper.TaskActionMapper;
import com.aaa.springcloud.mapper.TaskMapper;
import com.aaa.springcloud.mapper.TaskSchedulingMapper;
import com.aaa.springcloud.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskMapper taskMapper;
    @Autowired
    TaskActionMapper actionMapper;
    @Autowired
    TaskSchedulingMapper schedulingMapper;
    @Override
    public ReturnObj selectTaskAll(SearchTask task) {
        //分页操作
        int currentPage = task.getPage() == null ? 1:task.getPage();
        int pageSize = task.getLimit() == null ? 3:task.getLimit();
//        PageHelper.startPage(currentPage,pageSize);
        List<TaskVo> tvs =taskMapper.selSeaTask(task);
//        PageInfo<PlanVo> pageinfo = new PageInfo<PlanVo>(pvs);
//        Integer total = Integer.valueOf(pageinfo.getTotal()+"");
//        List<PlanVo> list = pageinfo.getList();
        return new ReturnObj(0,"",tvs.size(),tvs);
    }

    @Override
    public ReturnObj sqTask(TbTask task, Long emp_id) {
        int i = taskMapper.updTask(task);
        if (i==0){
            return new ReturnObj(400,"审批任务失败",i,null);
        }
        return new ReturnObj(200,"评审完成",i,i);
    }

    @Override
    public ReturnObj insertTask(TbTask task,List<Long> aemps, List<TbTaskScheduling> schedulings) {
        //验证信息是否完整
        if (null==task){
            return new ReturnObj(400,"工作任务表状态异常",null,null);
        }
        if (null==aemps || aemps.size()==0){
            return new ReturnObj(400,"执行人信息状态异常",null,null);
        }

        //添加
        int i = taskMapper.addTask(task);
        if (i==0){
            return new ReturnObj(400,"添加任务失败",null,null);
        }
        //验证是否添加成功
        SearchTask searchTask = new SearchTask();
        searchTask.setTask_no(task.getTask_no());
        List<TaskVo> taskVos = taskMapper.selSeaTask(searchTask);
        if (null==taskVos || taskVos.size()==0){
            return new ReturnObj(400,"添加成功，查询异常",null,null);
        }
        //取出刚添加的计划
        TaskVo taskVo=taskVos.get(0);
        Long task_id = taskVo.getTask_id();
        //添加执行人
        for (Long aemp : aemps) {
            TbTaskAction action = new TbTaskAction();
            action.setAction_emp_id(aemp);
            action.setTask_id(task_id);
            int j = actionMapper.insertTaskAction(action);
            if (j==0){
                return new ReturnObj(400,"添加任务执行人失败",null,null);
            }
        }
        //添加计划事项

        for (TbTaskScheduling scheduling : schedulings) {
            scheduling.setTask_id(task_id);
            int j = schedulingMapper.insertTaskScheduling(scheduling);
            if (j==0){
                return new ReturnObj(400,"添加任务事项失败",null,null);
            }
        }

        return new ReturnObj(200,"一切OK",0,"success");
    }

    @Override
    public int updTask(TbTask task) {
        return taskMapper.updTask(task);
    }

    @Override
    public ReturnObj delTask(Long taskId) {
        taskMapper.delTask(taskId);
        return null;
    }

    @Override
    public List<TbTaskType> selTaskTypes() {
        return taskMapper.selTaskTypes();
    }
}
