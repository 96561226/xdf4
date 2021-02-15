package com.aaa.springcloud.mapper;

import com.aaa.pojo.conference.PropertyApplyVo;
import com.aaa.pojo.conference.TbPropertyApply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PropertyApplyMapper {
    //条件分页查询
    List<PropertyApplyVo> selPropertyApplyByDT(PropertyApplyVo propertyApplyVo);
    //添加申请
    int addPropertyApply(TbPropertyApply tpa);
    //修改该表的状态
    int updPropertyApply(@Param("state") Integer state, @Param("applyId") Long applyId);
}
