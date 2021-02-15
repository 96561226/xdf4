package com.aaa.service.impl;

import com.aaa.mapper.RolesMapper;
import com.aaa.pojo.RoleVo;
import com.aaa.pojo.Roles;
import com.aaa.pojo.TransactionRole;
import com.aaa.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    RolesMapper rolesMapper;
    @Override
    public Roles selectRolesByNo(String empNo) {
        return rolesMapper.selectRolesByNo(empNo);
    }

    @Override
    public List<Roles> selectRoles() {
        return rolesMapper.selectRoles();
    }

    @Override
    public Roles selectRoleById(Long role_id) {
        return rolesMapper.selectRoleById(role_id);
    }

    @Override
    public int insertRole(Roles roles) {
        return rolesMapper.insertRole(roles);
    }

    @Override
    public int delRole(Long role_id) {
        return rolesMapper.delRole(role_id);
    }

    @Override
    public int updRole(Roles roles) {
        return rolesMapper.updRole(roles);
    }

    @Override
    public List<RoleVo> selectRVAll() {
        return rolesMapper.selectRVAll();
    }

    @Override
    public RoleVo selectRVById(Long role_id) {
        return rolesMapper.selectRVById(role_id);
    }

    @Override
    public int delRoleTransaction(Long role_id) {
        return rolesMapper.delRoleTransaction(role_id);
    }

    @Override
    public int addRoleTransaction(TransactionRole transactionRole) {
        return rolesMapper.addRoleTransaction(transactionRole);
    }
}
