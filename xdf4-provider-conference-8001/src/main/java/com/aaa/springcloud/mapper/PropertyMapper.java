package com.aaa.springcloud.mapper;

import com.aaa.pojo.conference.PropertyVo;
import com.aaa.pojo.conference.TbProperty;
import com.aaa.pojo.conference.TbPropertyState;
import com.aaa.pojo.conference.TbPropertyType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PropertyMapper {
    //模糊查询资产
    List<PropertyVo> selPropertyByMH(PropertyVo propertyVo);
    //模糊修改资产
    int updPropertyToMH(TbProperty tbProperty);
    //查询全部的状态类型
    List<TbPropertyState> selState();
    //查询全部的资产类型
    List<TbPropertyType> selType();
    //添加一个物品
    int addProperty(TbProperty tpy);
}
