package com.aaa.springcloud.controller;


import com.aaa.pojo.Emp;
import com.aaa.pojo.Transaction;
import com.aaa.springcloud.service.api.EmpService;
import com.aaa.springcloud.service.objectplan.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class NavController {
    @Autowired
    EmpService empService;
    @Autowired
    PlanService planService;

//    Long emp_id = (Long)SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0];
//    String emp_no = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[1].toString();
//    String emp_name = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[2].toString(); ;
//    String role_name = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[3].toString(); ;

    @RequestMapping("/")
    public String toIndex(){
        return "userLogin";
    }

    @RequestMapping("/toHome")

    public String toHome(Model model){
        //所有认证的信息都放在了下面的类中
        Authentication au = SecurityContextHolder.getContext().getAuthentication();
        String empNo = au.getName();

        //根据登录名找到用户
        Emp emp = empService.selectByNo(empNo);
        //根据用户找到角色
        List<Transaction> menus = new ArrayList<Transaction>();
       List<Transaction> transactions =  empService.selectResourcesByNo(emp.getEmp_no());
        for (Transaction BsResource : transactions) {

            if (BsResource.getParent_id()==0) {
                menus.add(BsResource);
            }
            for (Transaction it : transactions) {
                if (it.getParent_id() == BsResource.getTransaction_id().intValue()) {
                    if (BsResource.getChildren() == null) {
                        BsResource.setChildren(new ArrayList<Transaction>());
                    }
                    BsResource.getChildren().add(it);
                }
            }
        }


        model.addAttribute("menus",menus);
        model.addAttribute("username",emp.getEmp_name());
        model.addAttribute("emp_no",emp.getEmp_no());
        return "home";
    }

    @RequestMapping("/userLogin")
    public String toLogin(){
        return "login";
    }


    @RequestMapping("/error_403")
    public String to403(){
        return "deny_403";

    }

    @RequestMapping("/myError")
    public String myError(){
        return "error";
    }



}
