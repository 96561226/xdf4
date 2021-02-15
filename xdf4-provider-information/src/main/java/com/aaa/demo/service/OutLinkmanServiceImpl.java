package com.aaa.demo.service;

import com.aaa.demo.mapper.InLinkmanMapper;
import com.aaa.demo.mapper.OutLinkmanMapper;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.informaction.SearchOutlinkman;
import com.aaa.pojo.informaction.Tboutlinkman;
import com.aaa.pojo.informaction.TboutlinkmanVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OutLinkmanServiceImpl implements OutLinkmanService {
    @Autowired
    OutLinkmanMapper outLinkmanMapper;
    @Override
    public int insert(Tboutlinkman tboutlinkman) {
        return outLinkmanMapper.insert(tboutlinkman);
    }

    @Override
    public ReturnObj selectAll(SearchOutlinkman outlinkman) {
        int currentPage = outlinkman.getPage() == null ? 1:outlinkman.getPage();
        int pageSize = outlinkman.getLimit() == null ? 3:outlinkman.getLimit();
        PageHelper.startPage(currentPage,pageSize);
        List<TboutlinkmanVo> bs =outLinkmanMapper.selectAll(outlinkman);
        PageInfo<TboutlinkmanVo> pageinfo = new PageInfo<TboutlinkmanVo>(bs);
        Integer total = Integer.valueOf(pageinfo.getTotal()+"");
        List<TboutlinkmanVo> list = pageinfo.getList();
        return new ReturnObj(0,"",total,list);
    }

    @Override
    public int del(Integer id) {
        return outLinkmanMapper.del(id);
    }

    @Override
    public int update(Tboutlinkman tboutlinkman) {
        return outLinkmanMapper.update(tboutlinkman);
    }

    @Override
    public Tboutlinkman findByID(Integer id) {
        return outLinkmanMapper.findByID(id);
    }

    @Override
    public boolean delAll(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            outLinkmanMapper.del(id);
        }
        return flag;
    }
}
