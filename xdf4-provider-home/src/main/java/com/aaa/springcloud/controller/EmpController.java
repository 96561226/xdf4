package com.aaa.springcloud.controller;

import com.aaa.pojo.*;
import com.aaa.searchpojo.SearchEmp;
import com.aaa.springcloud.service.api.EmpService;
import com.aaa.springcloud.service.api.FormService;
import com.aaa.springcloud.service.systemmaster.RoleService;
import com.aaa.springcloud.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
public class EmpController extends BaseController {

    @Autowired
    EmpService empService;
    @Autowired
    RoleService roleService;
    @Autowired
    FormService formService;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @RequestMapping("/consumer/emps/selectSeaEmp")
    public List<EmpVo> selectSeaEmp(SearchEmp emp){
        return empService.selectSeaEmp(emp);
    }

    @RequestMapping("/consumer/emps/selectSeaEmps")
    public ReturnObj selectSeaEmps(SearchEmp emp){
        if (null==emp){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        List<EmpVo> empVos = empService.selectSeaEmp(emp);
        if (null==empVos || empVos.size()==0){
            return new ReturnObj(400,"查询结果为空",null,empVos);
        }
        return new ReturnObj(200,"查询成功",empVos.size(),empVos);
    }
    @RequestMapping(value = "/consumer/emps/empNo")
    public ReturnObj planNo(){
        return formService.selno("GH-","tb_emp","emp_id");
    }
    //修改员工
    @PostMapping("/consumer/emps/updEmp")
    public ReturnObj updEmp(Emp emp){
        if (null==emp){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        if (null!=emp.getPwd()){
            emp.setPwd(passwordEncoder.encode(emp.getPwd()));
        }
        int i = empService.updEmp(emp);
        if (i==0){
            return new ReturnObj(400,"修改失败",null,null);
        }
        return new ReturnObj(200,"修改成功",i,"success");
    };

    //修改密码
    @PostMapping("/consumer/emps/updMyEmp")
    public ReturnObj updMyEmp(Emp emp,String newPwd){

        if (null==emp.getEmp_no() || null==newPwd){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        Emp result = empService.selectByNo(emp.getEmp_no());
        System.out.println(result);
        if (null==result){
            return new ReturnObj(400,"传入参数错误",null,null);
        }
        String pwd = result.getPwd();
        System.out.println(pwd);
        if (!passwordEncoder.matches(emp.getPwd(),result.getPwd())){
            return new ReturnObj(400,"原密码错误",null,null);
        }
        int i = empService.changePassword(emp.getEmp_no(),passwordEncoder.encode(newPwd));
        if (i==0){
            return new ReturnObj(400,"修改失败",null,null);
        }
        return new ReturnObj(200,"修改成功",i,"success");
    };

    //添加员工
    @PostMapping("/consumer/emps/addEmp")
    public ReturnObj addEmp(Emp emp){
        if (null==emp){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        if (null==emp.getPwd()){
            emp.setPwd("123456");
        }
        emp.setPwd(passwordEncoder.encode(emp.getPwd()));
        int i = empService.addEmp(emp);
        if (i==0){
            return new ReturnObj(400,"添加失败",null,null);
        }
        return new ReturnObj(200,"添加成功",i,"success");
    };

    //删除员工
    @DeleteMapping("/consumer/emps/delEmp")
    public ReturnObj delEmp(Long emp_id){
        if (null==emp_id){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        int i = empService.delEmp(emp_id);
        if (i==0){
            return new ReturnObj(400,"删除失败",null,null);
        }
        return new ReturnObj(200,"删除成功",i,"success");
    };
}
