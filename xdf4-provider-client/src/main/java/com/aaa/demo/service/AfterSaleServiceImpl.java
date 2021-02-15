package com.aaa.demo.service;

import com.aaa.demo.mapper.AfterSaleMapper;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.client.SearchAfter;
import com.aaa.pojo.client.TbAfterState;
import com.aaa.pojo.client.TbafterSale;
import com.aaa.pojo.client.TbafterSaleVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AfterSaleServiceImpl implements AfterSaleService {
    @Autowired
    AfterSaleMapper afterSaleMapper;
    @Override
    public ReturnObj selectAll(SearchAfter searchAfter) {
        int currentPage = searchAfter.getPage() == null ? 1:searchAfter.getPage();
        int pageSize = searchAfter.getLimit() == null ? 3:searchAfter.getLimit();
        PageHelper.startPage(currentPage,pageSize);
        List<TbafterSaleVo> bs =afterSaleMapper.selectAll(searchAfter);
        PageInfo<TbafterSaleVo> pageinfo = new PageInfo<TbafterSaleVo>(bs);
        Integer total = Integer.valueOf(pageinfo.getTotal()+"");
        List<TbafterSaleVo> list = pageinfo.getList();
        return new ReturnObj(0,"",total,list);
    }

    @Override
    public int update(Integer s_id) {
        TbafterSale byID = findByID(s_id);
        if(byID.getState()==1){
            return afterSaleMapper.update(s_id);
        }else{
            return 0;
        }
    }

    @Override
    public TbafterSale findByID(Integer s_id) {
        return afterSaleMapper.findByID(s_id);
    }

    @Override
    public List<TbAfterState> selState() {
        return afterSaleMapper.selState();
    }
}
