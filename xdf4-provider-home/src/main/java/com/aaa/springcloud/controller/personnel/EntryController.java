package com.aaa.springcloud.controller.personnel;


import com.aaa.pojo.Emp;
import com.aaa.pojo.EmpVo;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.Roles;
import com.aaa.pojo.personnel.SearchEntry;
import com.aaa.pojo.personnel.TbEntry;
import com.aaa.pojo.personnel.TbEntryApprover;
import com.aaa.pojo.personnel.TbTransfer;
import com.aaa.springcloud.service.api.EmpService;
import com.aaa.springcloud.service.personnel.EntryService;
import com.aaa.springcloud.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/entry")
@RestController
public class EntryController extends BaseController {
    @Autowired
    EntryService entryService;
    @Autowired
    EmpService empService;
    @RequestMapping("/all")
    public ReturnObj selectEntryAll(SearchEntry entry){
        return entryService.selectEntryAll(entry);
    }
    @PostMapping("/cancellation")
    public ReturnObj cancellationRecruit(int id) {
        System.out.println(id);
        System.out.println("*************************************");
        return entryService.cancellationRecruit(id);
    }
    @PostMapping("/cancellations")
    public ReturnObj cancellationRecruits(@RequestParam("ids[]") int[] ids) {
        return entryService.cancellationRecruits(ids);
    }

    @GetMapping("/empRoleAndState")
    public ReturnObj empRoleAndState(){
        return entryService.empRoleAndState();
    }

    @GetMapping("/autoNo")
    public ReturnObj autoNo(){
        return entryService.autoNo();
    }

    @PostMapping("/add")
    public ReturnObj addRecruit(TbEntry entry){
        return entryService.addRecruit(entry);
    }

    @PostMapping("/addApprover")
    public ReturnObj addApprover(String[] arr,String no){
        return entryService.addApprover(arr,no);
    }


    //审批
    @PostMapping("/approve")
    public ReturnObj approve(TbEntry entry){
        Authentication au = SecurityContextHolder.getContext().getAuthentication();
        //获取页面当前登录人信息
        Object[] array = au.getAuthorities().toArray();
        //取出 登录人  id、no
        Long emp_id = Long.valueOf(array[0].toString()) ;
        String emp_no = array[1].toString();
        //根据 no 查询员工是否存在
        Emp emp = empService.selectByNo(emp_no);
        if (null==emp || null==emp.getEmp_id()){
            return new ReturnObj(400,"非法操作",null,null);
        }
        return entryService.approve(entry,emp_id);
    }
}
