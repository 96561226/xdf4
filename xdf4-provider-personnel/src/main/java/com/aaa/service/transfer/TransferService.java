package com.aaa.service.transfer;

import com.aaa.pojo.EmpVo;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.RoleVo;
import com.aaa.pojo.Roles;
import com.aaa.pojo.personnel.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransferService {
    //招聘  方法
    //新增招聘申请表
    int addTransfer(TbTransfer transfer);
    //作废招聘申请表
    int updateTransfer(TbTransfer transfer);
    //批量作废
    int cancellationTransfers(int[] ids);
    //查询入职表表id
    Long selectTransferNo(TbTransfer transfer);
    //添加审批人
    int insertTransferApprover(TbTransferApprover approver);
    //    生成编号
    String selNo(@Param("noName") String noName);
    //条件查询招聘申请表
    ReturnObj selectTransfer(SearchTransfer transfer);
    //查询所有离职类型
    List<TbTransferType> selectTypeAll();
    //根据员工Id查询员工部门，员工职位
    EmpVo selectEmpById(int id);
    //审批岗位调动表
    ReturnObj approveTransfer(TbTransfer transfer, Long emp_id);
}
