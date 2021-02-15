package com.aaa.springcloud.controller.systemmaster;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.Roles;
import com.aaa.springcloud.service.systemmaster.RoleService;
import com.aaa.springcloud.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController extends BaseController {
    @Autowired
    RoleService roleService;
    @GetMapping("/rs/selectRolesByNo")
    public ReturnObj selectRolesByNo(String empNo){
        if (null==empNo){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        return roleService.selectRolesByNo(empNo);
    };

    @GetMapping("/rs/selectRoles")
    public ReturnObj selectRoles(){
        return roleService.selectRoles();
    };

    @GetMapping("/rs/selectRoleById")
    public ReturnObj selectRoleById(Long role_id){
        if (null==role_id){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        return roleService.selectRoleById(role_id);
    };

    @PostMapping("/rs/insertRole")
    public ReturnObj insertRole(Roles roles){
        if (null==roles){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        return roleService.insertRole(roles);
    };

    @DeleteMapping("/rs/delRole")
    public ReturnObj delRole(Long role_id){
        if (null==role_id){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        return roleService.delRole(role_id);
    };

    @PostMapping("/rs/updRole")
    public ReturnObj updRole(Roles roles){
        if (null==roles){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        return roleService.updRole(roles);
    };

    @GetMapping("/rs/selectRVAll")
    public ReturnObj selectRVAll(){
        return roleService.selectRVAll();
    };

    @GetMapping("/rs/selectRVById")
    public ReturnObj selectRVById(Long role_id){
        System.out.println(role_id);
        if (null==role_id){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        ReturnObj returnObj = roleService.selectRVById(role_id);
        System.out.println(returnObj.getData());
        return returnObj;
    };

    @PostMapping("/rs/updRoleTransaction")
    public ReturnObj updRoleTransaction(Long role_id,@RequestParam("tids[]") Long[] tids){
        return roleService.updRoleTransaction(role_id,tids);
    };
}
