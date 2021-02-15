package com.aaa.controller;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.RoleVo;
import com.aaa.pojo.Roles;
import com.aaa.pojo.TransactionRole;
import com.aaa.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rs")
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/selectRolesByNo")
    public ReturnObj selectRolesByNo(@RequestParam("empNo") String empNo) {
        if (null==empNo){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        Roles roles = roleService.selectRolesByNo(empNo);
        if (null==roles){
            return new ReturnObj(400,"查询结果为空",null,roles);
        }
        return new ReturnObj(200,"查询成功",1,roles);
    }

    @GetMapping("/selectRoles")
    public ReturnObj selectRoles() {
        List<Roles> roles = roleService.selectRoles();
        if (null==roles || roles.size()==0){
            return new ReturnObj(400,"查询结果为空",null,roles);
        }
        return new ReturnObj(200,"查询成功",roles.size(),roles);
    }

    @GetMapping("/selectRoleById")
    public ReturnObj selectRoleById(@RequestParam("role_id") Long role_id) {
        if (null==role_id){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        Roles roles = roleService.selectRoleById(role_id);
        if (null==roles){
            return new ReturnObj(400,"查询结果为空",null,roles);
        }
        return new ReturnObj(200,"查询成功",1,roles);
    }


    @PostMapping("/insertRole")
    public ReturnObj insertRole(@RequestBody Roles roles) {
        if (null==roles){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        int i = roleService.insertRole(roles);
        if (i==0){
            return new ReturnObj(400,"添加失败",null,null);
        }
        return new ReturnObj(200,"添加成功",i,roles);
    }

    @DeleteMapping("/delRole")
    public ReturnObj delRole(@RequestParam("role_id") Long role_id) {
        if (null==role_id){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        int i = roleService.delRole(role_id);
        if (i==0){
            return new ReturnObj(400,"删除失败",null,null);
        }
        return new ReturnObj(200,"删除成功",i,role_id);
    }

    @PostMapping("/updRole")
    public ReturnObj updRole(@RequestBody Roles roles) {
        if (null==roles){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        int i = roleService.updRole(roles);
        if (i==0){
            return new ReturnObj(400,"修改失败",null,null);
        }
        return new ReturnObj(200,"修改成功",i,roles);
    }

    @GetMapping("/selectRVAll")
    public ReturnObj selectRVAll() {
        List<RoleVo> roleVos = roleService.selectRVAll();
        if (null==roleVos){
            return new ReturnObj(400,"查询失败",null,null);
        }
        return new ReturnObj(200,"修改成功",roleVos.size(),roleVos);
    }
    @GetMapping("/selectRVById")
    public ReturnObj selectRVById(@RequestParam("role_id") Long role_id) {
        if (null==role_id){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        RoleVo roleVos = roleService.selectRVById(role_id);
        if (null==roleVos){
            return new ReturnObj(400,"查询失败",null,null);
        }
        return new ReturnObj(200,"修改成功",1,roleVos);
    }

    @PostMapping("/updRoleTransaction")
    public ReturnObj updRoleTransaction(@RequestParam("role_id") Long role_id,@RequestParam("tids") Long[] tids) {
        if (null==role_id){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        roleService.delRoleTransaction(role_id);
        for (Long tid : tids) {
            TransactionRole transactionRole = new TransactionRole();
            transactionRole.setRole_id(role_id);
            transactionRole.setTid(tid);
            roleService.addRoleTransaction(transactionRole);
        }
        return new ReturnObj(400,"修改成功",null,"success");
    }
}
