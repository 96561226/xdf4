package com.aaa.service.travelling;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.finance.*;
import com.aaa.pojo.personnel.TbDimission;

import java.util.List;

public interface TravellingService {
    //差旅费报销  方法
    //新增差旅费报销申请表
    int addTravelling(TbTravelling travelling);
//    新增详情信息
    int addContents(TbTravellingContent content);
    //    新增审批人信息
    int addApprover(TbTravellingApprover approver);
    //    新增知会人信息
    int addNotify(TbTravellingNotify notify);
//    查询差旅费申请表id
    Long selectTravellingByNo(TbTravelling travelling);
    //    生成编号
    String selTravellingNo();
    //  查询员工部门
    Long selectDeptIdByEmpId(Long empId);
    //作废差旅费报销申请表
    int updateTravelling(TbTravelling tbTravelling);
    //作废多个
    int cancellationTravellings(int[] ids);
    //查询详细信息
    List<TbTravellingContent> selectTravellingContents(Integer id);
    //查询知会人
    List<TbTravellingNotifyVo> selectTravellingNotifys(Integer id);
    //条件查询差旅费报销申请表
    ReturnObj selectTravelling(SearchTravelling travelling);
    //审批离职表
    ReturnObj approveTravelling(TbTravelling travelling, Long emp_id);
}
