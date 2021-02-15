package com.aaa.demo.mapper;

import com.aaa.pojo.client.SearchAfter;
import com.aaa.pojo.client.TbAfterState;
import com.aaa.pojo.client.TbafterSale;
import com.aaa.pojo.client.TbafterSaleVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface AfterSaleMapper {


    List<TbafterSaleVo> selectAll(SearchAfter searchAfter);


    int update(Integer s_id);

    TbafterSale findByID(Integer s_id);

    /*查询状态*/
    List<TbAfterState> selState();
}
