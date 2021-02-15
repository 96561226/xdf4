package com.aaa.demo.mapper;

import com.aaa.pojo.informaction.SearchInlinkman;
import com.aaa.pojo.informaction.Tbinlinkman;
import com.aaa.pojo.informaction.TbinlinkmanVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface InLinkmanMapper {
    int insert(Tbinlinkman tbinlinkman);

    List<TbinlinkmanVo> selectAll(SearchInlinkman inlinkman);

    int del(Integer id);

    int update(Tbinlinkman tbinlinkman);

    Tbinlinkman findByID(Tbinlinkman tbinlinkman);

}
