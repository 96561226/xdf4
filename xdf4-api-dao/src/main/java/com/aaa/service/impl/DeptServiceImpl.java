package com.aaa.service.impl;

import com.aaa.mapper.DeptMapper;
import com.aaa.pojo.Dept;
import com.aaa.pojo.DeptVo;
import com.aaa.pojo.ReturnObj;
import com.aaa.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@Transactional
public class DeptServiceImpl implements DeptService {
    @Autowired
    DeptMapper deptMapper;
    @Override
    public ReturnObj insertDept(Dept dept) {
        Dept dp = deptMapper.selDeptById(dept.getDept_id());
        if (null!=dp){
            return new ReturnObj(400,"部门已存在",null,null);
        }
        int i = deptMapper.insertDept(dept);
        return new ReturnObj(200,"添加成功",i,i);
    }

    @Override
    public ReturnObj delDept(Long dept_id) {
        Dept dp = deptMapper.selDeptById(dept_id);
        if (null==dp){
            return new ReturnObj(400,"部门不存在",null,null);
        }
        DeptVo deptVo = deptMapper.selDeptVoById(dept_id);
        if (deptVo.getEmps().size()>0){
            return new ReturnObj(400,"部门员工未交接",null,null);
        }
        int i = deptMapper.delDept(dept_id);
        if (i<=0){
            return new ReturnObj(400,"并没有删除掉部门",i,i);
        }
        return new ReturnObj(200,"删除成功",i,i);
    }

    @Override
    public ReturnObj updDept(Dept dept) {
        System.out.println(dept);
        Dept dp = deptMapper.selDeptById(dept.getDept_id());
        if (null==dp){
            return new ReturnObj(400,"部门不存在",null,null);
        }
        int i = deptMapper.updDept(dept);
        if (i<=0){
            return new ReturnObj(400,"修改失败",i,i);
        }
        return new ReturnObj(200,"修改成功",i,i);
    }

    @Override
    public ReturnObj selDeptById(Long dept_id) {
        Dept dp = deptMapper.selDeptById(dept_id);
        if (null==dp){
            return new ReturnObj(400,"部门不存在",null,null);
        }
        return new ReturnObj(200,"查询成功",1,dp);
    }

    @Override
    public ReturnObj selDeptAll() {
        List<Dept> depts = deptMapper.selDeptAll();
        if (null==depts || depts.size()==0){
            return new ReturnObj(400,"查询失败，未查询到任何部门",0,null);
        }
        return new ReturnObj(200,"查询成功",depts.size(),depts);
    }

    @Override
    public ReturnObj selDeptVoAll() {
        List<DeptVo> deptVos = deptMapper.selDeptVoAll();
        if (null==deptVos || deptVos.size()==0){
            return new ReturnObj(400,"查询失败，未查询到任何部门",0,null);
        }
        return new ReturnObj(200,"查询成功",deptVos.size(),deptVos);
    }

    @Override
    public ReturnObj selDeptVoById(Long dept_id) {
        DeptVo deptVo = deptMapper.selDeptVoById(dept_id);
        if (null==deptVo){
            return new ReturnObj(400,"查询失败，未查询到任何部门",0,null);
        }
        return new ReturnObj(200,"查询成功",1,deptVo);
    }
}
