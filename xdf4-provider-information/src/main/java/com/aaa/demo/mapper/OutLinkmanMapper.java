package com.aaa.demo.mapper;

import com.aaa.pojo.informaction.SearchOutlinkman;
import com.aaa.pojo.informaction.Tboutlinkman;
import com.aaa.pojo.informaction.TboutlinkmanVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface OutLinkmanMapper {
    int insert(Tboutlinkman tboutlinkman);

    List<TboutlinkmanVo> selectAll(SearchOutlinkman outlinkman);

    int del(Integer id);

    int update(Tboutlinkman tboutlinkman);

    Tboutlinkman findByID(Integer id);
}
