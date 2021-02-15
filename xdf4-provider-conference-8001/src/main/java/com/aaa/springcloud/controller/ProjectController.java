package com.aaa.springcloud.controller;

import com.aaa.pojo.CommonResult;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.project.ProjectVo;
import com.aaa.pojo.project.TbProject;
import com.aaa.springcloud.config.BaseController;
import com.aaa.springcloud.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ProjectController extends BaseController {
    @Autowired
    ProjectService projectService;

    @RequestMapping("/Project/List")
    public ReturnObj selProjectAll(@RequestBody ProjectVo projectVo){
       return projectService.selProjectAll(projectVo);
    }
    @GetMapping("/Project/cs")
    public List selCS(){
        return projectService.selCS();
    }

    @PostMapping("/Project/add")
    public CommonResult addProject(@RequestBody TbProject tbProject){
        int i = projectService.addProject(tbProject);
        if (i!=0){
            return new CommonResult(0,"登记成功",null);
        }else {
            return new CommonResult(400,"登记失败",null);
        }
    }
    @PostMapping("/Project/upd")
    public CommonResult updProject(@RequestBody TbProject tbProject){
        int i = projectService.updProject(tbProject);
        if (i!=0){
            return new CommonResult(0,"修改进度成功",null);
        }else {
            return new CommonResult(400,"修改进度失败",null);
        }
    }
}
