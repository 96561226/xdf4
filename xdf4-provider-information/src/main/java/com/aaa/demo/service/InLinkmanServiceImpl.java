package com.aaa.demo.service;

import com.aaa.demo.mapper.InLinkmanMapper;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.informaction.SearchInlinkman;
import com.aaa.pojo.informaction.Tbinlinkman;
import com.aaa.pojo.informaction.TbinlinkmanVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class InLinkmanServiceImpl implements InLinkmanService {
    @Autowired
    InLinkmanMapper inLinkmanMapper;
    @Override
    public int insert(Tbinlinkman tbinlinkman) {
        return inLinkmanMapper.insert(tbinlinkman);
    }

    @Override
    public ReturnObj selectAll(SearchInlinkman inlinkman) {
        int currentPage = inlinkman.getPage() == null ? 1:inlinkman.getPage();
        int pageSize = inlinkman.getLimit() == null ? 3:inlinkman.getLimit();
        PageHelper.startPage(currentPage,pageSize);
        List<TbinlinkmanVo> bs =inLinkmanMapper.selectAll(inlinkman);
        PageInfo<TbinlinkmanVo> pageinfo = new PageInfo<TbinlinkmanVo>(bs);
        Integer total = Integer.valueOf(pageinfo.getTotal()+"");
        List<TbinlinkmanVo> list = pageinfo.getList();
        return new ReturnObj(0,"",total,list);
    }

    @Override
    public int del(Integer id) {
        return inLinkmanMapper.del(id);
    }

    @Override
    public int update(Tbinlinkman tbinlinkman) {
        Tbinlinkman byID = findByID(tbinlinkman);
        if(byID!=null){
            return inLinkmanMapper.update(tbinlinkman);
        }else{
            return insert(tbinlinkman);
        }
    }

    @Override
    public Tbinlinkman findByID(Tbinlinkman tbinlinkman) {
        return inLinkmanMapper.findByID(tbinlinkman);
    }

    @Override
    public boolean delAll(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            inLinkmanMapper.del(id);
        }
        return flag;
    }
}
