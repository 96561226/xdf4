package com.aaa.service.impl;

import com.aaa.mapper.EmpMapper;
import com.aaa.mapper.RolesMapper;
import com.aaa.mapper.TransactionMapper;
import com.aaa.pojo.*;

import com.aaa.searchpojo.SearchEmp;
import com.aaa.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Transactional
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    EmpMapper empMapper;

    @Autowired
    RolesMapper rolesMapper;

    @Autowired
    TransactionMapper transactionMapper;

    @Override
    public Emp selectByNoPwd(Emp emp) {
        System.out.println("selectByNoPwd"+emp);
        return empMapper.selectByNoPwd(emp);
    }

    @Override
    public Roles selectRolesByNo(String empNo) {
        return rolesMapper.selectRolesByNo(empNo);
    }

    @Override
    public List<Transaction> selectResourcesByNo(String empNo) {
        //根据工号查询岗位角色
        Roles role = this.selectRolesByNo(empNo);
        //根据角色查找所有的资源
        List<Transaction> transactions = null;
        if (null != role){
            transactions = transactionMapper.selectByRoleId(role.getRole_id());
        }
        return transactions;
    }

    @Override
    public Emp selectByNo(String empNo) {
        System.out.println("selectByNo"+empNo);
        return empMapper.selectByNo(empNo);
    }

    @Override
    public int changePassword(String empNo, String pwd) {
        return empMapper.updatePwd(empNo,pwd);
    }

    @Override
    public List<Emp> selectAll() {
        return empMapper.selectAll();
    }

    @Override
    public List<EmpVo> selectSeaEmp(SearchEmp emp) {
        return empMapper.selectSeaEmp(emp);
    }

    @Override
    public int addEmp(Emp emp) {
        Long role_id = emp.getRole_id();
        if (null==role_id){
            return 0;
        }
        Roles roles = rolesMapper.selectRoleById(role_id);
        emp.setDept_id(roles.getDept_id());
        if (null==emp.getHiredate()){
            emp.setHiredate(new Date());
        }
        if (null==emp.getSal()){
            emp.setSal(0.00);
        }
        if (null==emp.getComm()){
            emp.setComm(0.00);
        }
        if (null==emp.getPwd()){
            emp.setPwd("$2a$10$xXvC4MMP3xBmeJjENinsyO.t1CfEMUttttvlrX/xnOsvfoybvEUfS");
        }
        return empMapper.insert(emp);
    }

    @Override
    public int updEmp(Emp emp) {
        Long role_id = emp.getRole_id();
        if (null==role_id){
            return empMapper.updEmp(emp);
        }
        Roles roles = rolesMapper.selectRoleById(role_id);
        emp.setDept_id(roles.getDept_id());
        return empMapper.updEmp(emp);
    }

    @Override
    public int delEmp(Long emp_id) {
        return empMapper.delEmp(emp_id);
    }
}
