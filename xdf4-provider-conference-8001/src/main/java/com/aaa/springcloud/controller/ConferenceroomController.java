package com.aaa.springcloud.controller;

import com.aaa.pojo.CommonResult;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.conference.*;
import com.aaa.springcloud.config.BaseController;
import com.aaa.springcloud.service.ConferenceroomService;
import com.aaa.springcloud.service.PropertyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ConferenceroomController extends BaseController {
    @Autowired
    ConferenceroomService conferenceroomService;
    @Autowired
    PropertyService propertyService;
    //点击会议室列表时查询出全部的基本信息
    @GetMapping("/Conferenceroom/List")
    public CommonResult ConferenceroomList(){
        List<ConferenceroomVo> conferenceroomVos = conferenceroomService.selConferenceroomList();
        if (conferenceroomVos!=null){
            return new CommonResult(0,"查询成功",conferenceroomVos);
        }else {
            return new CommonResult(400,"没有记录",null);
        }
    }
    //点击详情时需要查询该会议室的使用情况 通过id查询
    @GetMapping("/Conferenceroom/List/ApplyByid")
    public CommonResult selApplyByid(@RequestParam("id") Long id){
        List<ConferenceroomApplyVo> conferenceroomApplyVos = conferenceroomService.selConferenceroomApplyById(id);
        for (ConferenceroomApplyVo i:
                conferenceroomApplyVos ) {
        }
        if (conferenceroomApplyVos!=null){
            return new CommonResult(0,"查询成功",conferenceroomApplyVos);
        }else {
            return new CommonResult(400,"没有记录",null);
        }
    }

    @RequestMapping("/Conferenceroom/List/Property")//点击查看设备详情
    public CommonResult selRoomProperById(@RequestBody Long conferenceRoomId){
        List<ConferenceroomPropertyVo> conferenceroomPropertyVos = conferenceroomService.selRoomProperById(conferenceRoomId);
        if (conferenceroomPropertyVos!=null&&conferenceroomPropertyVos.size()!=0){
            return new CommonResult(0,"查询成功",conferenceroomPropertyVos);
        }else {
            return new CommonResult(0,"没有记录",null);
        }
    }
    //添加设备时先查询所有空闲的设备 查询全部闲置且不可借用的物品
    @GetMapping("/Conferenceroom/List/ProperByid")
    public CommonResult selPropertyByPid(){
        PropertyVo pv=new PropertyVo();
        pv.setStateId((long) 2);
        pv.setPropertyState(2);
        List<PropertyVo> propertyVos = propertyService.selPropertyByMH(pv);
        if (null!=propertyVos&&propertyVos.size()>0 ){
            return new CommonResult(200,"查询成功",propertyVos);
        }else {
            return new CommonResult(444,"没有记录",null);
        }
    }
    //添加一个资产和会议室的关系 并修改资产状态
    @PostMapping("/Conferenceroom/List/addRPUpdP")
    public CommonResult addRPUpdP(@RequestBody TbConferenceroomProperty tcp){
        //联合运行
        int i = conferenceroomService.addRPUpdP(tcp);
        if (i!=0){
            return new CommonResult(200,"添加成功");
        }else {
            return new CommonResult(400,"添加失败");
        }
    }
    //删除一个资产和会议室的关系 并修改资产状态
    @PostMapping("/Conferenceroom/List/delRPUpdP")
    public CommonResult delRPUpdP(@RequestParam("PropertyId") Long PropertyId){
        int i = conferenceroomService.delRPUpdP(PropertyId);
        if (i!=0){
            return new CommonResult(200,"删除成功");
        }else {
            return new CommonResult(400,"删除失败");
        }
    }
    //在添加申请时 给予下拉 房间查询 单表查询 和添加序列
    @GetMapping("/Conferenceroom/List/Apply")
    public CommonResult a(){
       return conferenceroomService.selRoomAndApplyAndCount();
    };
    //点击添加申请
    @PostMapping("/Conferenceroom/List/addApplyAndApprover")
    public CommonResult addApplyAndApprover(@RequestBody TbConferenceroomApply tca,@RequestParam("empids") Long[] empids){
        int i = conferenceroomService.addApplyAndApprover(tca,empids);
        if (i==1){
            return new CommonResult(200,"申请提交成功");
        }else if (i==0){
            return new CommonResult(400,"申请提交失败");
        }else {
            return new CommonResult(600,"时间原因提交失败");
        }
    }
    //查询全部使用情况 分页查询
    @RequestMapping("/Conferenceroom/ApplyList")
    public ReturnObj selAllApply(@RequestBody SearchApply say){
        conferenceroomService.updStateByDate();
        return conferenceroomService.selAllConRoomApply(say);
    }

    //审核区
    //根据审批人id查询 之未审核
    @GetMapping("/Conferenceroom/Approver")
    public CommonResult selApproverByIdOnDai(@RequestBody SearchApply searchApply){
        List<ConferenceroomApplyVo> conferenceroomApplyVos = conferenceroomService.selApproverByDT(searchApply);
        if (conferenceroomApplyVos.size()!=0){
            return new CommonResult(0,"查询成功",conferenceroomApplyVos);
        }else {
            return new CommonResult(0,"查询失败",null);
        }
    }
    @PostMapping("/Conferenceroom/SH")
    public CommonResult SH(@RequestParam("empId")Long empId,@RequestParam("state")Integer state,@RequestParam("apply_id")Long apply_id){
        int i = conferenceroomService.cfRoomApprover(empId, state, apply_id);
        if (i!=0){
            return new CommonResult(0,"审核成功",null);
        }else {
            return new CommonResult(400,"未知原因审核失败！请通知管理员处理",null);
        }
    }
    @PostMapping("/Conferenceroom/CH")
    public CommonResult CH(@RequestParam("apply_id")Long apply_id){
        int approverch = conferenceroomService.Approverch(apply_id);
        if (approverch!=0){
            return new CommonResult(0,"申请撤回成功",null);
        }else {
            return new CommonResult(400,"未知原因撤回失败！请通知管理员处理",null);
        }
    }
}
