package com.aaa.springcloud.controller;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.plans.TbTask;
import com.aaa.pojo.plans.TbTaskScheduling;
import com.aaa.pojo.plans.TbTaskType;
import com.aaa.searchpojo.SearchPlan;
import com.aaa.searchpojo.SearchTask;
import com.aaa.springcloud.service.TaskService;
import com.aaa.springcloud.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController extends BaseController {
    @Autowired
    TaskService taskService;
    //条件查询工作任务
    @RequestMapping("/tasks")
    public ReturnObj selectAll(@RequestBody SearchTask task){
        ReturnObj obj = taskService.selectTaskAll(task);
        System.out.println("***************"+obj.getData());
        return obj;
    }

    //审批工作任务
    @PostMapping("/spTask")
    public ReturnObj spTask(@RequestBody TbTask task, @RequestParam("emp_id") Long emp_id){
        return taskService.sqTask(task,emp_id);
    }

    @PostMapping("/insertTask")
    public ReturnObj insertTask( @RequestBody TbTask task, @RequestParam("aemps") List<Long> aemps,
                                 @RequestParam("task_schedulings")String[] task_schedulings) {
        List<TbTaskScheduling> schedulings = new ArrayList<>();
        for (int i=0;i<task_schedulings.length;i++){
            TbTaskScheduling tbTaskScheduling = new TbTaskScheduling();
            tbTaskScheduling.setScheduling(task_schedulings[i]);
            schedulings.add(tbTaskScheduling);
        }
        return taskService.insertTask(task,aemps,schedulings);
    }

    @DeleteMapping("/delTask")
    public ReturnObj delTask(@RequestParam("taskId") Long taskId) {
        return taskService.delTask(taskId);
    }

    @GetMapping("/selTaskTypes")
    public ReturnObj selTaskTypes() {
        List<TbTaskType> tbTaskTypes = taskService.selTaskTypes();
        if (null==tbTaskTypes){
            return new ReturnObj(400,"查询失败",null,tbTaskTypes);
        }
        return new ReturnObj(200,"查询成功",tbTaskTypes.size(),tbTaskTypes);
    }

}
