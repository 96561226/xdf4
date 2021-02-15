package com.aaa.demo.service;

import com.aaa.demo.mapper.ClientMapper;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.client.SearchClient;
import com.aaa.pojo.client.Tbclient;
import com.aaa.pojo.client.TbclientVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientMapper clientMapper;
    @Override
    public int insert(Tbclient tbclient) {
        return clientMapper.insert(tbclient);
    }

    @Override
    public ReturnObj selectAll(SearchClient searchClient) {
        int currentPage = searchClient.getPage() == null ? 1:searchClient.getPage();
        int pageSize = searchClient.getLimit() == null ? 3:searchClient.getLimit();
        PageHelper.startPage(currentPage,pageSize);
        List<TbclientVo> bs =clientMapper.selectAll(searchClient);
        PageInfo<TbclientVo> pageinfo = new PageInfo<TbclientVo>(bs);
        Integer total = Integer.valueOf(pageinfo.getTotal()+"");
        List<TbclientVo> list = pageinfo.getList();
        return new ReturnObj(0,"",total,list);
    }

    @Override
    public List<Tbclient> selectCname() {
        return clientMapper.selectCname();
    }

    @Override
    public int del(Integer c_id) {
        return clientMapper.del(c_id);
    }

    @Override
    public int update(Tbclient tbclient) {
        return clientMapper.update(tbclient);
    }

    @Override
    public Tbclient findByID(Integer c_id) {
        return clientMapper.findByID(c_id);
    }

    @Override
    public boolean delAll(Integer[] ids) {
        boolean flag = true;
        for (Integer id : ids) {
            clientMapper.del(id);
        }
        return flag;
    }
}
