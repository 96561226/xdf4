package com.aaa.mapper.entry;

import com.aaa.pojo.personnel.TbEntry;
import com.aaa.pojo.personnel.TbEntryApprover;
import com.aaa.pojo.personnel.TbEntryApproverVo;
import com.aaa.pojo.personnel.TbTransferApprover;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface EntryApproverMapper {
    /*根据招聘id查询审批人*/
    List<TbEntryApproverVo> selectEntryApprovers(Long id);
//    添加招聘表审批人
    int insertEntryApprover(TbEntryApprover approver);
    //    审批人审批
    int updateState(TbEntryApprover approver);
}
