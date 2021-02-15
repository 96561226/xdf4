package com.aaa.springcloud.service.conference;

import com.aaa.pojo.CommonResult;
import com.aaa.pojo.ReturnObj;

import com.aaa.pojo.conference.SearchApply;
import com.aaa.pojo.conference.TbConferenceroomApply;
import com.aaa.pojo.conference.TbConferenceroomProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@Component
@FeignClient(value = "XDF4-PROVIDER-CONFERENCE",contextId="room" )
public interface ConferenceroomService {
    @GetMapping("/Conferenceroom/List")
    public CommonResult ConferenceroomList();
    //点击详情时需要查询该会议室的使用情况 通过id查询
    @GetMapping("/Conferenceroom/List/ApplyByid")
    public CommonResult selApplyByid(@RequestParam("id") Long id);

    @RequestMapping("/Conferenceroom/List/Property")//点击查看设备详情
    public CommonResult selRoomProperById(@RequestBody Long conferenceRoomId);
    //添加设备时先查询所有空闲的设备 查询全部闲置且不可借用的物品
    @GetMapping("/Conferenceroom/List/ProperByid")
    public CommonResult selPropertyByPid();
    //添加一个资产和会议室的关系 并修改资产状态
    @PostMapping("/Conferenceroom/List/addRPUpdP")
    public CommonResult addRPUpdP(@RequestBody TbConferenceroomProperty tcp);
    //删除一个资产和会议室的关系 并修改资产状态
    @PostMapping("/Conferenceroom/List/delRPUpdP")
    public CommonResult delRPUpdP(@RequestParam("PropertyId") Long PropertyId);
    //在添加申请时 给予下拉 房间查询 单表查询 和添加序列
    @GetMapping("/Conferenceroom/List/Apply")
    public CommonResult a();
    //点击添加申请
    @PostMapping("/Conferenceroom/List/addApplyAndApprover")
    public CommonResult addApplyAndApprover(@RequestBody TbConferenceroomApply tca, @RequestParam("empids") Long[] empids);
    //查询全部使用情况 分页查询

    @RequestMapping("/Conferenceroom/ApplyList")
    public ReturnObj selAllApply(@RequestBody SearchApply say);

    //审核区
    //根据审批人id查询 之未审核
    @GetMapping("/Conferenceroom/Approver")
    public CommonResult selApproverByIdOnDai(@RequestBody SearchApply searchApply);
    //审核
    @PostMapping("/Conferenceroom/SH")
    public CommonResult SH(@RequestParam("empId") Long empId, @RequestParam("state") Integer state, @RequestParam("apply_id") Long apply_id);
    //撤回
    @PostMapping("/Conferenceroom/CH")
    public CommonResult CH(@RequestParam("apply_id") Long apply_id);
}
