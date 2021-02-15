package com.aaa.mapper.dimission;

import com.aaa.pojo.personnel.TbDimissionApprover;
import com.aaa.pojo.personnel.TbDimissionApproverVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DimissionApproverMapper {
    /*根据招聘id查询审批人*/
    List<TbDimissionApproverVo> selectDimissionApprovers(Long id);
//    添加招聘表审批人
    int insertDimissionApprover(TbDimissionApprover approver);
    //    审批人审批
    int updateState(TbDimissionApprover approver);
}
