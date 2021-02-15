package com.aaa.springcloud.service;

import com.aaa.pojo.CommonResult;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.conference.*;

import java.util.List;

public interface ConferenceroomService {
    //会议室区---------------------
    //点击会议室列表时查询出全部的基本信息
    List<ConferenceroomVo> selConferenceroomList();
    //点击详情时需要查询该会议室的使用情况 通过id查询
    List<ConferenceroomApplyVo> selConferenceroomApplyById(Long id);

    //点击查看设备详情
    List<ConferenceroomPropertyVo> selRoomProperById(Long conferenceRoomId);
    //添加一个资产和会议室的关系 并修改资产状态
    int addRPUpdP(TbConferenceroomProperty tcp);
    //删除一个资产和会议室的关系 并修改资产状态
    int delRPUpdP(Long PropertyId);

    //在添加申请时 给予下拉 房间查询 单表查询 和添加序列
    CommonResult selRoomAndApplyAndCount();
    //点击添加申请 添加申请 查询申请查出id 添加 审批人
    int addApplyAndApprover(TbConferenceroomApply tca, Long[] empids);
    //判断所有日期是否过期 如果过期 改状态  前判断结束日期是否已过去
    int updStateByDate();
    //查询全部的使用情况
    ReturnObj selAllConRoomApply(SearchApply searchApply);

    //审核区
    //动态查询审批信息
    List<ConferenceroomApplyVo> selApproverByDT(SearchApply searchApply);

    //会议室申请审批审批
    int cfRoomApprover(Long empId, Integer state, Long apply_id);
    //撤回申请时的操作
    int Approverch(Long apply_id);

}
