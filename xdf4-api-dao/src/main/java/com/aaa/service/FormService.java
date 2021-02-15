package com.aaa.service;


import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.TbFormState;
import com.aaa.pojo.TbTaskState;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

public interface FormService {
    //查询所有申请状态信息
    ReturnObj selFormStateAll();

    //查询所有任务状态信息
    ReturnObj selTaskStateAll();

    //查询所有报告状态信息
    ReturnObj selStatementStateAll();

    //根据状态id查询状态名字
    ReturnObj selFormStateById(Long state_id);

    ReturnObj selNo(String noName, String tableName, String idName);

    //查询审批人
    List<Long> selApprover(Long dept_ids);

}
