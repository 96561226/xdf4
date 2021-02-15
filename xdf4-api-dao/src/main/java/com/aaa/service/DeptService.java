package com.aaa.service;


import com.aaa.pojo.Dept;
import com.aaa.pojo.DeptVo;
import com.aaa.pojo.ReturnObj;

import java.util.List;

public interface DeptService {
    ReturnObj insertDept(Dept dept);

    ReturnObj delDept(Long dept_id);

    ReturnObj updDept(Dept dept);

    ReturnObj selDeptById(Long dept_id);

    ReturnObj selDeptAll();

    //查询所有部门详细信息
    ReturnObj selDeptVoAll();
    //根据部门id查询部门
    ReturnObj selDeptVoById(Long dept_id);
}
