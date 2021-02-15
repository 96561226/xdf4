package com.aaa.service;

import com.aaa.pojo.Emp;
import com.aaa.pojo.EmpVo;
import com.aaa.pojo.Roles;
import com.aaa.pojo.Transaction;
import com.aaa.searchpojo.SearchEmp;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmpService {
    //查询登录用户
    Emp selectByNoPwd(Emp emp);

    //查询登录用户获得的角色
    Roles selectRolesByNo(String empNo);

    //查询登录用户对应的功能
    List<Transaction> selectResourcesByNo(String empNo);

    //根据工号获取用户信息
    Emp selectByNo(String empNo);

    //修改密码
    int changePassword(String empNo, String pwd);

    List<Emp> selectAll();

    //条件查询员工
    List<EmpVo> selectSeaEmp(SearchEmp emp);

    //添加员工
    int addEmp(Emp emp);

    //修改员工
    int updEmp(Emp emp);

    //删除员工
    int delEmp(Long emp_id);
}
