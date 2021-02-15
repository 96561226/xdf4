package com.aaa.mapper.travelling;

import com.aaa.pojo.finance.SearchTravelling;
import com.aaa.pojo.finance.TbTravelling;
import com.aaa.pojo.finance.TbTravellingVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface TravellingMapper {
    //差旅费报销  方法
    //新增差旅费报销申请表
    int addTravelling(TbTravelling travelling);
    //  查询员工部门
    Long selectDeptIdByEmpId(Long empId);

    //修改差旅费报销申请表
    int updateTravelling(TbTravelling travelling);
    //条件查询差旅费报销申请表
    List<TbTravellingVo> selectTravelling(SearchTravelling travelling);
}
