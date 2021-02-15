package com.aaa.springcloud.service.systemmaster;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.RoleVo;
import com.aaa.pojo.Roles;
import com.aaa.pojo.TransactionRole;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(value = "XDF4-API-DAO",contextId = "roleId")
public interface RoleService {
    @GetMapping("/rs/selectRolesByNo")
    public ReturnObj selectRolesByNo(@RequestParam("empNo") String empNo);

    @GetMapping("/rs/selectRoles")
    public ReturnObj selectRoles();

    @GetMapping("/rs/selectRoleById")
    public ReturnObj selectRoleById(@RequestParam("role_id") Long role_id);

    @PostMapping("/rs/insertRole")
    public ReturnObj insertRole(@RequestBody Roles roles);

    @DeleteMapping("/rs/delRole")
    public ReturnObj delRole(@RequestParam("role_id")Long role_id);

    @PostMapping("/rs/updRole")
    public ReturnObj updRole(@RequestBody Roles roles);

    @GetMapping("/rs/selectRVAll")
    public ReturnObj selectRVAll();

    @GetMapping("/rs/selectRVById")
    public ReturnObj selectRVById(@RequestParam("role_id") Long role_id);

    @PostMapping("/rs/updRoleTransaction")
    public ReturnObj updRoleTransaction(@RequestParam("role_id") Long role_id,@RequestParam("tids") Long[] tids);
}
