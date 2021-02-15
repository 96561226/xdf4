package com.aaa.service.recruit;

import com.aaa.pojo.*;
import com.aaa.pojo.personnel.SearchRecruit;
import com.aaa.pojo.personnel.TbRecruit;
import com.aaa.pojo.personnel.TbRecruitApprover;
import com.aaa.pojo.personnel.TbTransfer;
import org.apache.ibatis.annotations.Param;

public interface RecruitService {
    //招聘  方法
    //新增招聘申请表
    int addRecruit(TbRecruit recruit);
    //  查询员工部门
    Long selectDeptIdByEmpId(Long empId);
    //作废招聘申请表
    int updateRecruit(TbRecruit recruit);
    //批量删除
    int cancellationRecruits(int[] ids);
    //添加审批人
    int insertRecruitApprover(TbRecruitApprover approver);
    //查询差旅费申请表id
    Long selectRecruitNo(TbRecruit recruit);
    //    生成编号
    String selNo(@Param("noName") String noName);
    //条件查询招聘申请表
    ReturnObj selectRecruit(SearchRecruit recruit);
    //审批招聘表
    ReturnObj approveRecruit(TbRecruit recruit, Long emp_id);
}
