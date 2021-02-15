package com.aaa.springcloud.mapper;

import com.aaa.pojo.project.ProjectVo;
import com.aaa.pojo.project.TbProject;
import com.aaa.pojo.project.TbProjectType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ProjectMapper {
    //查询全部数据动态
    List<ProjectVo> selProjectDT(ProjectVo projectVo);
    //查询全部的类型
    List<TbProjectType> selProjectType();
    //登记一个项目
    int addProject(TbProject tbProject);
    //修改项目进度
    int updProject(TbProject tbProject);
}
