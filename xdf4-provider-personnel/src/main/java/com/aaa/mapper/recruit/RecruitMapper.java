package com.aaa.mapper.recruit;

import com.aaa.pojo.personnel.SearchRecruit;
import com.aaa.pojo.personnel.TbRecruit;
import com.aaa.pojo.personnel.TbRecruitVo;
import com.aaa.pojo.personnel.TbTransfer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface RecruitMapper {
    //招聘  方法
    //新增招聘申请表
    int addRecruit(TbRecruit recruit);
//  查询员工部门
    Long selectDeptIdByEmpId(Long empId);
    //修改招聘申请表状态
    int updateRecruit(TbRecruit recruit);
//    生成编号
    String selNo(@Param("noName") String noName);
    //条件查询招聘申请表
    List<TbRecruitVo> selectRecruit(SearchRecruit recruit);
}
