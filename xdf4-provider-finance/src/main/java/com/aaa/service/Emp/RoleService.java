package com.aaa.service.Emp;

import com.aaa.pojo.Roles;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@FeignClient(value = "XDF4-API-DAO",contextId = "roleId")
public interface RoleService {
    //根据登录工号找到对应的角色
    @GetMapping("/rs/selectRolesByNo")
    Roles selectRolesByNo(String empNo);
    @GetMapping("/rs/selectRoles")
    List<Roles> selectRoles();
    @GetMapping("/rs/insertRole")
    int insertRole(Roles roles);
    @GetMapping("/rs/delRole")
    int delRole(Long role_id);
    @GetMapping("/rs/updRole")
    int updRole(Roles roles);
}
