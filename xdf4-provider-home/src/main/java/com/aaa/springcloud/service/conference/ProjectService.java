package com.aaa.springcloud.service.conference;

import com.aaa.pojo.CommonResult;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.project.ProjectVo;
import com.aaa.pojo.project.TbProject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@FeignClient(value = "XDF4-PROVIDER-CONFERENCE",contextId="project")
public interface ProjectService {
    @RequestMapping("/Project/List")
    public ReturnObj selProjectAll(@RequestBody ProjectVo projectVo);
    @GetMapping("/Project/cs")
    public List selCS();
    @PostMapping("/Project/add")
    public CommonResult addProject(@RequestBody TbProject tbProject);
    @PostMapping("/Project/upd")
    public CommonResult updProject(@RequestBody TbProject tbProject);
}
