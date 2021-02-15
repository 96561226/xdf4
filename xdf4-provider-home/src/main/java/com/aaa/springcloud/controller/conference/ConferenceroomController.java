package com.aaa.springcloud.controller.conference;

import com.aaa.pojo.CommonResult;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.conference.SearchApply;
import com.aaa.pojo.conference.TbConferenceroomApply;
import com.aaa.pojo.conference.TbConferenceroomProperty;
import com.aaa.springcloud.service.conference.ConferenceroomService;
import com.aaa.springcloud.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConferenceroomController extends BaseController {
    @Autowired
    ConferenceroomService conferenceroomService;
    @GetMapping("/Conferenceroom/List")
    public CommonResult ConferenceroomList(){
        return conferenceroomService.ConferenceroomList();
    };
    //点击详情时需要查询该会议室的使用情况 通过id查询
    @GetMapping("/Conferenceroom/List/ApplyByid")
    public CommonResult selApplyByid(Long id){
        return conferenceroomService.selApplyByid(id);
    };

    @RequestMapping("/Conferenceroom/List/Property")//点击查看设备详情
    public CommonResult selRoomProperById(Long conferenceRoomId){
        return conferenceroomService.selRoomProperById(conferenceRoomId);
    };
    //添加设备时先查询所有空闲的设备 查询全部闲置且不可借用的物品
    @GetMapping("/Conferenceroom/List/ProperByid")
    public CommonResult selPropertyByPid(){
        return conferenceroomService.selPropertyByPid();
    };
    //添加一个资产和会议室的关系 并修改资产状态
    @PostMapping("/Conferenceroom/List/addRPUpdP")
    public CommonResult addRPUpdP(TbConferenceroomProperty tcp){
        return conferenceroomService.addRPUpdP(tcp);
    };
    //删除一个资产和会议室的关系 并修改资产状态
    @PostMapping("/Conferenceroom/List/delRPUpdP")
    public CommonResult delRPUpdP(Long PropertyId){
        return conferenceroomService.delRPUpdP(PropertyId);
    };
    //在添加申请时 给予下拉 房间查询 单表查询 和添加序列
    @GetMapping("/Conferenceroom/List/Apply")
    public CommonResult a(){
        return conferenceroomService.a();
    };
    //点击添加申请
    @PostMapping("/Conferenceroom/List/addApplyAndApprover")
    public CommonResult addApplyAndApprover(TbConferenceroomApply tca,Long[] empids){
        return conferenceroomService.addApplyAndApprover(tca,empids);
    };
    //查询全部使用情况 分页查询
    @RequestMapping("/Conferenceroom/ApplyList")
    public ReturnObj selAllApply(SearchApply say){
        return conferenceroomService.selAllApply(say);
    };

    //审核区
    //根据审批人id查询 之未审核
    @GetMapping("/Conferenceroom/Approver")
    public CommonResult selApproverByIdOnDai(SearchApply searchApply){
        return conferenceroomService.selApproverByIdOnDai(searchApply);
    };
    @PostMapping("/Conferenceroom/SH")
    public CommonResult SH(Long empId,Integer state,Long apply_id){
        return conferenceroomService.SH(empId,state,apply_id);
    }
    //撤回
    @PostMapping("/Conferenceroom/CH")
    public CommonResult SH(@RequestParam("apply_id")Long apply_id){
        return conferenceroomService.CH(apply_id);
    }
    @GetMapping("/Conferenceroom/yanzheng")
    public String yz(){
        Authentication au = SecurityContextHolder.getContext().getAuthentication();
        Object[] array = au.getAuthorities().toArray();
        String emp_name = array[1].toString();
        return emp_name;
    }
    @GetMapping("/Conferenceroom/getid")
    public String getid(){
        Authentication au = SecurityContextHolder.getContext().getAuthentication();
        Object[] array = au.getAuthorities().toArray();
        String emp_id = array[0].toString();
        return emp_id;
    }

}
