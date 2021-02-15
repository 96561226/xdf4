package com.aaa.springcloud.mapper;

import com.aaa.pojo.conference.ConferenceroomApproverVo;
import com.aaa.pojo.conference.TbConferenceroomApprover;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ConferenceroomApproverMapper {
    //查询所有审批人 使用一对多
    List<ConferenceroomApproverVo> selCAV();
    //添加审批人表
    int addConferenceroomApprover(TbConferenceroomApprover tca);
    //修改审批人
    int updConferenceroomApprover(TbConferenceroomApprover tbConferenceroomApprover);
}
