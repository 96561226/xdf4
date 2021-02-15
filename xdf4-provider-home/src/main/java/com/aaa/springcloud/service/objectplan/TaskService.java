package com.aaa.springcloud.service.objectplan;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.plans.TbTask;
import com.aaa.pojo.plans.TbTaskScheduling;
import com.aaa.pojo.plans.TbTaskType;
import com.aaa.searchpojo.SearchTask;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Component
@FeignClient(value = "XDF4-PROVIDE-OBJECTPLAN",contextId = "taskId")
public interface TaskService {

    @RequestMapping("/task/tasks")
    public ReturnObj selectAll(@RequestBody SearchTask task);

    //审批工作任务
    @PostMapping("/task/spTask")
    public ReturnObj spTask(@RequestBody TbTask task, @RequestParam("emp_id") Long emp_id);

    @PostMapping("/task/insertTask")
    public ReturnObj insertTask( @RequestBody TbTask task, @RequestParam("aemps") List<Long> aemps,
                                 @RequestParam("task_schedulings")String[] task_schedulings);

    @DeleteMapping("/task/delTask")
    public ReturnObj delTask(@RequestParam("taskId") Long taskId);

    @GetMapping("/task/selTaskTypes")
    public ReturnObj selTaskTypes();
}
