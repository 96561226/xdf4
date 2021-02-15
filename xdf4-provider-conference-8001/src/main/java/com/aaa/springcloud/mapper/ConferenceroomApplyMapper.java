package com.aaa.springcloud.mapper;

import com.aaa.pojo.conference.ConferenceroomApplyVo;
import com.aaa.pojo.conference.SearchApply;
import com.aaa.pojo.conference.TbConferenceroomApply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ConferenceroomApplyMapper {
    //动态查询审批信息
    List<ConferenceroomApplyVo> selApplyByDT(SearchApply searchApply);
    //修改 申请表的状态
    int updTbConferenceroomApp(@Param("state") Integer state, @Param("apply_id") Long apply_id);
    //添加修改
    int addConferenceroomApp(TbConferenceroomApply tbConferenceroomApply);
    //判断时间
    List<TbConferenceroomApply> selConferenceroomApplyByTime(TbConferenceroomApply tca);
}
