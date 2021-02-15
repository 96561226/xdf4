package com.aaa.springcloud.controller.plan;

import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.plans.TbTask;
import com.aaa.pojo.plans.TbTaskCharge;
import com.aaa.pojo.plans.TbTaskScheduling;
import com.aaa.searchpojo.SearchTask;
import com.aaa.springcloud.service.api.EmpService;
import com.aaa.springcloud.service.api.FormService;
import com.aaa.springcloud.service.objectplan.TaskService;
import com.aaa.springcloud.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class TaskController extends BaseController {
    @Autowired
    TaskService taskService;

    @Autowired
    EmpService empService;

    @Autowired
    FormService formService;

    //查询工作计划
    @RequestMapping(value = "/consumer/task/tasks")
    public ReturnObj tasks(SearchTask task){
        return taskService.selectAll(task);
    }
    //返回当前最新的工作计划编号
    @RequestMapping(value = "/consumer/task/taskNo")
    public ReturnObj planNo(){
        return formService.selno("RW-","tb_task","task_id");
    }

    @PostMapping(value = "/consumer/task/spTask")
    public ReturnObj spTask(TbTask task){
        TbTaskCharge tbPlanCharge = new TbTaskCharge();

        Authentication au = SecurityContextHolder.getContext().getAuthentication();
        Object[] array = au.getAuthorities().toArray();

        Long emp_id = Long.valueOf(array[0].toString()) ;
        String emp_no = array[1].toString();

        Emp emp = empService.selectByNo(emp_no);
        if (null==emp || null==emp.getEmp_id()){
            return new ReturnObj(400,"非法操作",null,null);
        }

        return taskService.spTask(task,emp_id);
    }

    @PostMapping("/consumer/task/insertTask")
    public ReturnObj insertTask(TbTask task, String[] action_emps,String[] task_schedulings){
        Authentication au = SecurityContextHolder.getContext().getAuthentication();
        Object[] array = au.getAuthorities().toArray();
        Long emp_id = Long.valueOf(array[0].toString()) ;

        //完善工作计划详情
        task.setEmp_id(emp_id);
        task.setCdate(new Date());

        List<Long> aemps = new ArrayList<>();
        for (String action_emp : action_emps) {
            aemps.add(Long.valueOf(action_emp));
        }
        List<TbTaskScheduling> schedulings = new ArrayList<>();
        for (int i=0;i<task_schedulings.length;i++){
            TbTaskScheduling tbTaskScheduling = new TbTaskScheduling();
            tbTaskScheduling.setScheduling(task_schedulings[i]);
            schedulings.add(tbTaskScheduling);
        }

        return taskService.insertTask(task,aemps,task_schedulings);
    };

    @GetMapping("/consumer/task/selTaskTypes")
    public ReturnObj selPlanTypes(){
        return taskService.selTaskTypes();
    };
}
