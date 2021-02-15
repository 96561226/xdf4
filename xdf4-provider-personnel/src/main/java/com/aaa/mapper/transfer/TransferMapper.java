package com.aaa.mapper.transfer;

import com.aaa.pojo.EmpVo;
import com.aaa.pojo.personnel.SearchTransfer;
import com.aaa.pojo.personnel.TbTransfer;
import com.aaa.pojo.personnel.TbTransferType;
import com.aaa.pojo.personnel.TbTransferVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TransferMapper {
    //招聘  方法
    //新增招聘申请表
    int addTransfer(TbTransfer transfer);
    //修改岗位调动表状态
    int updateTransfer(TbTransfer transfer);
    //    生成编号
    String selNo(@Param("noName") String noName);
    //条件查询招聘申请表
    List<TbTransferVo> selectTransfer(SearchTransfer transfer);
    //查询所有调动类型
    List<TbTransferType> selectTypeAll();
    //根据员工Id查询员工部门，员工职位
    EmpVo selectEmpById(Integer id);

    List<TbTransfer> selectByState(TbTransfer transfer);

}
