package com.aaa.service.dimission;

import com.aaa.pojo.*;
import com.aaa.pojo.personnel.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DimissionService {
    //招聘  方法
    //新增招聘申请表
    int addDimission(TbDimission dimission);
    //作废招聘申请表
    int updateDimission(TbDimission dimission);
    //批量删除
    int cancellationDimissions(int[] ids);
    //查询入职表表id
    Long selectDimissionNo(TbDimission dimission);
    //添加审批人
    int insertDimissionApprover(TbDimissionApprover approver);
    //    生成编号
    String selDimissionNo(@Param("noName") String noName);
    //条件查询招聘申请表
    ReturnObj selectDimission(SearchDimission dimission);
    //查询所有离职类型
    List<TbDimissionType> selectDimissionTypeAll();
    //审批离职表
    ReturnObj approveDimission(TbDimission dimission, Long emp_id);
}
