package com.aaa.demo.mapper;

import com.aaa.pojo.client.TbPactApprover;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface ApproverMapper {
   List<TbPactApprover> selApprover(Integer p_id);
   /*修改审批人状态*/
   int updateApprover(TbPactApprover approver);
}
