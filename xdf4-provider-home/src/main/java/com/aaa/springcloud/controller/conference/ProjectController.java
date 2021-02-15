package com.aaa.springcloud.controller.conference;

import com.aaa.pojo.CommonResult;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.project.ProjectVo;
import com.aaa.pojo.project.TbProject;
import com.aaa.springcloud.service.conference.ProjectService;
import com.aaa.springcloud.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController extends BaseController {
    @Autowired
    ProjectService projectService;
    @RequestMapping("/Project/List")
    public ReturnObj selProjectAll(ProjectVo projectVo){
        return projectService.selProjectAll(projectVo);
    }
    @GetMapping("/Project/cs")
    public List selCS(){
        return projectService.selCS();
    }
    @PostMapping("/Project/add")
    public CommonResult addProject(TbProject tbProject){
        return projectService.addProject(tbProject);
    }
    @PostMapping("/Project/upd")
    public CommonResult updProject(TbProject tbProject){
        return projectService.updProject(tbProject);
    }
}
