package com.aaa.service.Emp;

import com.aaa.pojo.ReturnObj;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "XDF4-API-DAO",contextId = "formId")
public interface FormService {
    //查询所有申请状态信息
    @GetMapping("/formapi/fstates")
    public ReturnObj selFormStateAll();

    //根据状态id查询状态名字
    @GetMapping("/formapi/fstate")
    public ReturnObj selFormStateById(@RequestParam("state_id") Long state_id);

    @GetMapping("/formapi/selnoapi")
    public ReturnObj selno(@RequestParam("noName") String noName, @RequestParam("tableName") String tableName, @RequestParam("idName") String idName);

    //查询审批人
    @GetMapping("/formapi/selapprover")
    public List<Long> selApprover(@RequestParam("dept_id") Long dept_id);

    //添加 申请-审批、知会、执行人
    @PostMapping("/formapi/addFormEmps")
    public int addFormEmps(@RequestParam("tableName") String tableName, @RequestParam("acolName") String acolName, @RequestParam("fcolName") String fcolName, @RequestParam("approver_emp_id") Long approver_emp_id, @RequestParam("form_id") Long form_id);
}
