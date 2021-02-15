package com.aaa.springcloud.service;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.project.ProjectVo;
import com.aaa.pojo.project.TbProject;

import java.util.List;

public interface ProjectService {
    //动态查询全部项目
    ReturnObj selProjectAll(ProjectVo projectVo);
    //查询全部的类型
    List selCS();
    //登记一个项目
    int addProject(TbProject tbProject);
    //修改项目进度
    int updProject(TbProject tbProject);
}
