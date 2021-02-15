package com.aaa.springcloud.controller.personnel;


import com.aaa.pojo.Emp;
import com.aaa.pojo.EmpVo;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.Roles;
import com.aaa.pojo.personnel.SearchRecruit;
import com.aaa.pojo.personnel.TbEntry;
import com.aaa.pojo.personnel.TbRecruit;
import com.aaa.pojo.personnel.TbRecruitApprover;
import com.aaa.springcloud.service.api.EmpService;
import com.aaa.springcloud.service.personnel.RecruitService;
import com.aaa.springcloud.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/recruit")
@RestController
public class RecruitController extends BaseController {

    @Autowired
    RecruitService recruitService;
    @Autowired
    EmpService empService;
    @RequestMapping("/all")
    public ReturnObj selectRecruitAll(SearchRecruit recruit){
        return recruitService.selectRecruitAll(recruit);
    }
    @PostMapping("/cancellation")
    public ReturnObj cancellationRecruit(int id) {
        return recruitService.cancellationRecruit(id);
    }
    @PostMapping("/cancellations")
    public ReturnObj cancellationRecruits(int[] ids) {
        return recruitService.cancellationRecruits(ids);
    }
    @GetMapping("/empRoleAndState")
    public ReturnObj empRoleAndState(){
        return recruitService.empRoleAndState();
    }
    @GetMapping("/autoNo")
    public ReturnObj autoNo(){
        return recruitService.autoNo();
    }

    @PostMapping("/add")
    public ReturnObj addRecruit(TbRecruit recruit){
        return recruitService.addRecruit(recruit);
    }
    @PostMapping("/addApprover")
    public ReturnObj addApprover(String[] arr,String no){
        return recruitService.addApprover(arr,no);
    }

    @GetMapping("/selectSeaEmp")
    public List<EmpVo> selectSeaEmp(){
        return recruitService.selectSeaEmp();
    }

    //审批
    @PostMapping("/approve")
    public ReturnObj approve(TbRecruit recruit){
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
        return recruitService.approve(recruit,emp_id);
    }
}
