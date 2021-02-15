package com.aaa.mapper.recruit;

import com.aaa.pojo.personnel.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface RecruitApproverMapper {
    /*根据招聘id查询审批人*/
    List<TbRecruitApproverVo> selectRecruitApprovers(Long id);
//    添加招聘表审批人
    int insertRecruitApprover(TbRecruitApprover approver);
    //    审批人审批
    int updateState(TbRecruitApprover approver);
}
