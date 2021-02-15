package com.aaa.mapper.dimission;

import com.aaa.pojo.personnel.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DimissionMapper {
    //离职  方法
    //新增离职申请表
    int addDimission(TbDimission dimission);
    //  查询员工部门
    Long selectDeptIdByEmpId(Long empId);
    //修改离职申请表状态
    int updateDimission(TbDimission dimission);
    //    生成编号
    String selNo(@Param("noName") String noName);
    //条件查询离职申请表
    List<TbDimissionVo> selectDimission(SearchDimission dimission);
    //查询所有离职类型
    List<TbDimissionType> selectTypeAll();

}
