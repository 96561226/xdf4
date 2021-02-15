package com.aaa.springcloud.service;

import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.finance.TbIncome;
import com.aaa.pojo.informaction.Tbdocument;
import com.aaa.pojo.plans.TbTask;
import com.aaa.pojo.project.ProjectVo;
import com.aaa.pojo.project.TbProject;
import com.aaa.pojo.project.TbProjectType;
import com.aaa.springcloud.mapper.ProjectMapper;
import com.aaa.springcloud.mapper.UtilMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    //外置接口调用
    @Resource
    WZService wzService;
    @Autowired
    UtilMapper utilMapper;
    //内置
    @Autowired
    ProjectMapper projectMapper;

    @Override
    public ReturnObj selProjectAll(ProjectVo projectVo) {
        int currentPage = projectVo.getPage() == null ? 1:projectVo.getPage();
        int pageSize = projectVo.getLimit() == null ? 5:projectVo.getLimit();
        PageHelper.startPage(currentPage,pageSize);
        List<ProjectVo> projectVos = projectMapper.selProjectDT(projectVo);
        PageInfo<ProjectVo> pageinfo = new PageInfo<ProjectVo>(projectVos);
        Integer total = Integer.valueOf(pageinfo.getTotal()+"");
        List<ProjectVo> list = pageinfo.getList();
        return new ReturnObj(0,"",total,list);
    }

    @Override
    public List selCS() {
        List list=new ArrayList();
        //查询全部的项目类型
        List<TbProjectType> tbProjectTypes = projectMapper.selProjectType();
        list.add(tbProjectTypes);
        //查询编号
        ReturnObj XM = wzService.selno("XM-", "tb_project", "project_id");
        list.add(XM.getData().toString());
        //查询全部的可用任务用于项目
        List<TbTask> tbTasks = utilMapper.selTask();
        list.add(tbTasks);
        //查询全部的可用文档用于项目
        List<Tbdocument> tbdocuments = utilMapper.selDocument();
        list.add(tbdocuments);
        //查询所有金额 用于项目
        List<TbIncome> tbIncomes = utilMapper.selIncome();
        list.add(tbIncomes);

        return list;
    }

    @Override
    public int addProject(TbProject tbProject) {
        //查询编号
        ReturnObj SZ = wzService.selno("SZ-", "tb_income", "income_id");
        //查询员工部门
        Emp selemp = utilMapper.selemp(tbProject.getEmpId());
        tbProject.getProjectBeginTime();
        TbIncome tbIncome=new TbIncome();
        tbIncome.setIncomeNo(SZ.getData().toString());
        tbIncome.setInvolveType((long)4);
        tbIncome.setMoney((double)tbProject.getProjectPredictMoney());
        tbIncome.setRegister(tbProject.getEmpId());
        tbIncome.setEmpId(tbProject.getEmpId());
        tbIncome.setDeptId(selemp.getDept_id());
        tbIncome.setIncomeDeclare(tbProject.getProjectRemark());
        tbIncome.setState((long)2);
        //添加一条财务
        int i = utilMapper.addIncome(tbIncome);
        return projectMapper.addProject(tbProject);
    }

    @Override
    public int updProject(TbProject tbProject) {
        return projectMapper.updProject(tbProject);
    }
}
