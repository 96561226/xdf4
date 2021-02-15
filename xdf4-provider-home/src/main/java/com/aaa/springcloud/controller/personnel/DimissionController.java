package com.aaa.springcloud.controller.personnel;


import com.aaa.pojo.Emp;
import com.aaa.pojo.EmpVo;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.personnel.*;
import com.aaa.springcloud.service.api.EmpService;
import com.aaa.springcloud.service.personnel.DimissionService;
import com.aaa.springcloud.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/dimission")
@RestController
public class DimissionController extends BaseController {
    @Autowired
    DimissionService dimissionService;
    @Autowired
    EmpService empService;
    @RequestMapping("/all")
    public ReturnObj selectEntryAll(SearchDimission dimission){
        return dimissionService.selectEntryAll(dimission);
    }
    @PostMapping("/cancellation")
    public ReturnObj cancellationRecruit(int id) {
        return dimissionService.cancellationDimission(id);
    }
    @PostMapping("/cancellations")
    public ReturnObj cancellationRecruits(@RequestParam("ids[]") int[] ids) {
        return dimissionService.cancellationRecruits(ids);
    }

    @GetMapping("/empRoleAndState")
    public ReturnObj empRoleAndState(){
        return dimissionService.empRoleAndState();
    }

    @GetMapping("/autoNo")
    public ReturnObj autoNo(){
        return dimissionService.autoNo();
    }

    @PostMapping("/add")
    public ReturnObj addRecruit(TbDimission dimission){
        return dimissionService.addRecruit(dimission);
    }

    @PostMapping("/addApprover")
    public ReturnObj addApprover(String[] arr,String no){
        return dimissionService.addApprover(arr,no);

    }


    //审批
    @PostMapping("/approve")
    public ReturnObj approve(TbDimission dimission){
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
        return dimissionService.approve(dimission,emp_id);
    }
}
