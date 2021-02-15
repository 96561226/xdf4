package com.aaa.mapper;

import com.aaa.pojo.Dept;
import com.aaa.pojo.DeptVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface DeptMapper {
    //添加部门
    int insertDept(Dept dept);

    //删除部门
    int delDept(Long dept_id);

    //修改部门
    int updDept(Dept dept);

    //根据部门id查询部门
    Dept selDeptById(Long dept_id);

    //查询所有部门。
    List<Dept> selDeptAll();

    //查询所有部门详细信息
    List<DeptVo> selDeptVoAll();
    //根据部门id查询部门
    DeptVo selDeptVoById(Long dept_id);

    
}
