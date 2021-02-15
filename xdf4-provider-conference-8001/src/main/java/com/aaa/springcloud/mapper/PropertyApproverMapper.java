package com.aaa.springcloud.mapper;

import com.aaa.pojo.conference.PropertyApproverVo;
import com.aaa.pojo.conference.TbPropertyApprover;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PropertyApproverMapper {
    //查询所有
    List<PropertyApproverVo> selPropertyApproverAll();
    //添加审批人
    int addPropertyApprover(TbPropertyApprover tbPropertyApprover);
   //修改审批人的状态
    int updPropertyApprover(TbPropertyApprover tbPropertyApprover);
}
