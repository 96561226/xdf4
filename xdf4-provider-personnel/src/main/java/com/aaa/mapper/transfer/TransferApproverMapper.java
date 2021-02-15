package com.aaa.mapper.transfer;


import com.aaa.pojo.personnel.TbEntryApproverVo;
import com.aaa.pojo.personnel.TbTransfer;
import com.aaa.pojo.personnel.TbTransferApprover;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TransferApproverMapper {
    /*根据招聘id查询审批人*/
    List<TbEntryApproverVo> selectTransferApprovers(Long id);
//    添加招聘表审批人
    int insertTransferApprover(TbTransferApprover approver);
//    审批人审批
    int updateState(TbTransferApprover approver);
}
