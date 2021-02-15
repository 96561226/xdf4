package com.aaa.service.impl;

import com.aaa.mapper.FormMapper;
import com.aaa.pojo.*;
import com.aaa.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class FormServiceImpl implements FormService {
    @Autowired
    FormMapper formMapper;
    @Override
    public ReturnObj selFormStateAll() {
        List<TbFormState> tbFormState = formMapper.selStateAll();
        if (null==tbFormState || tbFormState.size()==0){
            return new ReturnObj(400,"查询失败，数据库无数据",null,null);
        }
        return new ReturnObj(200,"查询成功",tbFormState.size(),tbFormState);
    }

    @Override
    public ReturnObj selTaskStateAll() {
        List<TbTaskState> taskStates = formMapper.selTaskStateAll();
        if (null==taskStates || taskStates.size()==0){
            return new ReturnObj(400,"查询失败，数据库无数据",null,null);
        }
        return new ReturnObj(200,"查询成功",taskStates.size(),taskStates);
    }

    @Override
    public ReturnObj selStatementStateAll() {
        List<TbStatementState> statementStates = formMapper.selStatementStateAll();
        if (null==statementStates || statementStates.size()==0){
            return new ReturnObj(400,"查询失败，数据库无数据",null,null);
        }
        return new ReturnObj(200,"查询成功",statementStates.size(),statementStates);
    }

    @Override
    public ReturnObj selFormStateById(Long state_id) {
        TbFormState tbFormState = formMapper.selStateById(state_id);
        if (null==tbFormState){
            return new ReturnObj(400,"查询失败，数据库无数据",null,null);
        }
        return new ReturnObj(200,"查询成功",1,tbFormState);
    }

    @Override
    public ReturnObj selNo(String noName, String tableName, String idName) {
        String selNo = formMapper.selNo(noName, tableName, idName);
        if (null==selNo){
            return new ReturnObj(400,"查询失败，数据库无数据",null,null);
        }
        return new ReturnObj(200,"查询成功",1,selNo);
    }

    @Override
    public List<Long> selApprover(Long dept_id) {
        return formMapper.selApprover(dept_id);
    }

}
