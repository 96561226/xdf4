package com.aaa.mapper.recruit;

import com.aaa.pojo.personnel.TbRecruitNotify;
import com.aaa.pojo.personnel.TbRecruitNotifyVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface RecruitNotifyMapper {
    /*根据招聘id查询知会人*/
    List<TbRecruitNotifyVo> selectRecruitNotifys(Long id);
    int insertRecruitNotify(TbRecruitNotify notify);
}
