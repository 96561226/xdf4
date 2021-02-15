package com.aaa.service.entry;

import com.aaa.mapper.entry.EntryApproverMapper;
import com.aaa.mapper.entry.EntryMapper;
import com.aaa.mapper.entry.EntryNotifyMapper;
import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.personnel.*;
import com.aaa.service.Emp.EmpService;
import com.aaa.service.Emp.FormService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.experimental.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EntryServiceImpl implements EntryService {
    @Autowired
    EntryMapper entryMapper;
    @Autowired
    EntryApproverMapper approverMapper;
    @Autowired
    EntryNotifyMapper notifyMapper;
    @Autowired
    FormService formService;
    @Autowired
    EmpService empService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public int addEntry(TbEntry entry) {
        int i = entryMapper.addEntry(entry);
        Long entryId = selectEntryNo(entry);
        List<Long> longs = formService.selApprover(entry.getDeptId());
        for (int j = 0; j < longs.size(); j++) {
            if (longs.get(j) != entry.getEmpId()){
                i = notifyMapper.insertEntryNotify(new TbEntryNotify(entryId,longs.get(j)));
            }
        }
        return i;
    }

    @Override
    public int updateEntry(TbEntry tbEntry) {
        SearchEntry entry = new SearchEntry();
        entry.setEntryId(Long.valueOf(tbEntry.getEntryId()));
        List<TbEntryVo> tbRecruitVos = entryMapper.selectEntry(entry);
        if (tbRecruitVos.get(0).getState() == 1){
            return entryMapper.updateEntry(tbEntry);
        }else {
            return 0;
        }
    }

    @Override
    public int cancellationEntrys(int[] ids) {
        int result = 0;
        for (int i = 0; i < ids.length; i++) {
            TbEntry entry = new TbEntry();
            entry.setState(Long.valueOf(4));
            entry.setEntryId(Long.valueOf(ids[i]));
            result = updateEntry(entry);
        }
        return result;
    }

    @Override
    public Long selectEntryNo(TbEntry entry) {
        SearchEntry searchEntry = new SearchEntry(entry);
        List<TbEntryVo> tbEntryVos = entryMapper.selectEntry(searchEntry);
        return tbEntryVos.get(0).getEntryId();
    }

    @Override
    public int insertEntryApprover(TbEntryApprover approver) {
        return approverMapper.insertEntryApprover(approver);
    }

    @Override
    public String selNo(String noName) {
        return entryMapper.selNo(noName);
    }

    @Override
    public ReturnObj selectEntry(SearchEntry entry) {
        int currentPage = entry.getPage() == null ? 1:entry.getPage();
        int pageSize = entry.getLimit() == null ? 3:entry.getLimit();
        PageHelper.startPage(currentPage,pageSize);
        List<TbEntryVo> es =entryMapper.selectEntry(entry);
        PageInfo<TbEntryVo> pageinfo = new PageInfo<TbEntryVo>(es);
        Integer total = Integer.valueOf(pageinfo.getTotal()+"");
        List<TbEntryVo> list = pageinfo.getList();
        return new ReturnObj(0,"success",total,list);
    }

    @Override
    public ReturnObj approveEntry(TbEntry entry, Long emp_id) {
        //修改入职表状态
        int i = entryMapper.updateEntry(entry);
        if (i==0){
            return new ReturnObj(400,"审批失败",i,null);
        }
        ReturnObj selno = formService.selno("GH-", "tb_emp", "emp_id");
        String empNo = String.valueOf(selno.getData());
        Emp emp = new Emp();
        emp.setEmp_no(empNo);
        emp.setDept_id(entry.getDeptId());
        emp.setRole_id(entry.getRoleId());
        emp.setEmp_name(entry.getEmpName());
        emp.setHiredate(entry.getEntryDate());
        emp.setSal(0.0);
        emp.setComm(0.0);
        emp.setPwd(passwordEncoder.encode("123456"));
        int e = empService.insert(emp);
        if (e==0){
            return new ReturnObj(400,"岗位调动失败",e,null);
        }
        //修改审批人状态
        TbEntryApprover approver = new TbEntryApprover();
        approver.setEmpId(emp_id);
        approver.setEntryId(entry.getEntryId());
        int j = approverMapper.updateState(approver);
        if (j==0){
            return new ReturnObj(400,"审批人状态异常",i,null);
        }

        return new ReturnObj(200,"审批完成",i,i);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
