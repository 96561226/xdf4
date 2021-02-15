package com.aaa.springcloud.controller.finance;

import com.aaa.pojo.Emp;
import com.aaa.pojo.EmpVo;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.finance.*;
import com.aaa.pojo.personnel.TbTransfer;
import com.aaa.springcloud.service.api.EmpService;
import com.aaa.springcloud.service.finance.TravellingService;
import com.aaa.springcloud.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/travelling")
@RestController
public class TravellingController extends BaseController {

    @Autowired
    TravellingService travellingService;
    @Autowired
    EmpService empService;
    @RequestMapping("/all")
    public ReturnObj selectTravelingAll(SearchTravelling travelling){
        return travellingService.selectTravelingAll(travelling);
    }

    @GetMapping("/empAndDept")
    public ReturnObj selectAllEmp(){
        return travellingService.selectAllEmp();
    }

    @GetMapping("/content")
    public ReturnObj selectTravellingContents( int id){
        return travellingService.selectTravellingContents(id);
    }

    @GetMapping("/notify")
    public ReturnObj selectTravellingNotifys( int id){
        return travellingService.selectTravellingNotifys(id);
    }

    @PostMapping("/add")
    public ReturnObj addTravelling(TbTravelling travelling){
        return travellingService.addTravelling(travelling);
    }

    @PostMapping("/addContent")
    public ReturnObj addContent(String[] arr){
        return travellingService.addContent(arr);
    }

    @GetMapping("/autoNo")
    public ReturnObj autoNo(){
        return travellingService.autoNo();
    }

    @PostMapping("/cancellation")
    public ReturnObj cancellationTravelling(int id) {
        return travellingService.cancellationTravelling(id);
    }

    @PostMapping("/cancellations")
    public ReturnObj cancellationTravellings(int[] ids) {
        return travellingService.cancellationTravellings(ids);
    }

    @PostMapping("/addApprover")
    public ReturnObj addApprover(String[] arr,String no){
        return travellingService.addApprover(arr,no);
    }

    @GetMapping("/selectSeaEmp")
    public List<EmpVo> selectSeaEmp(){
        return travellingService.selectSeaEmp();
    }

    //审批
    @PostMapping("/approve")
    public ReturnObj approve(TbTravelling travelling){
        Authentication au = SecurityContextHolder.getContext().getAuthentication();
        Object[] array = au.getAuthorities().toArray();

        Long emp_id = Long.valueOf(array[0].toString()) ;
        String emp_no = array[1].toString();

        Emp emp = empService.selectByNo(emp_no);
        if (null==emp || null==emp.getEmp_id()){
            return new ReturnObj(400,"非法操作",null,null);
        }
        return travellingService.approve(travelling,emp_id);
    }
}
