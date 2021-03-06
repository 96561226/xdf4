package com.aaa.mapper;

import com.aaa.pojo.RoleVo;
import com.aaa.pojo.Roles;
import com.aaa.pojo.TransactionRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface RolesMapper {
    //根据登录工号找到对应的角色
    Roles selectRolesByNo(String EmpNo);

    //根据部门找到对应的角色
    List<Roles> selectRolesByDept(Long dept_id);

    List<Roles> selectRoles();

    Roles selectRoleById(Long role_id);

    int insertRole(Roles roles);

    int delRole(Long role_id);

    int updRole(Roles roles);

    //查询所有角色与其对应-资源
    List<RoleVo> selectRVAll();

    //查询角色与其对应-资源
    RoleVo selectRVById(Long role_id);

    //删除角色对应的资源关系
    int delRoleTransaction(Long role_id);
    //添加角色对应的资源关系
    int addRoleTransaction(TransactionRole transactionRole);
}
