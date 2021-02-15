package com.aaa.mapper.travelling;

import com.aaa.pojo.finance.TbTravellingApprover;
import com.aaa.pojo.finance.TbTravellingApproverVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TravellingApproverMapper {
//    差旅费报销审批人查询
    List<TbTravellingApproverVo> selectAllApproverByTravellingId(Long id);
    //    差旅费报销审批人添加
    int insertTravellingApprover(TbTravellingApprover travellingApprover);
//    修改审批人状态
    int updateApproverState(TbTravellingApprover approver);
}
