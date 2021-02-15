package com.aaa.springcloud.controller;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.plans.TbStatement;
import com.aaa.pojo.plans.TbStatementScheduling;
import com.aaa.pojo.plans.TbStatementType;
import com.aaa.searchpojo.SearchStatement;
import com.aaa.springcloud.service.StatementService;
import com.aaa.springcloud.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/statement")
public class StatementController extends BaseController {
    @Autowired
    StatementService statementService;
    //条件查询工作计划
    @RequestMapping("/statements")
    public ReturnObj selectAll(@RequestBody SearchStatement statement){
        ReturnObj obj = statementService.selectStatementAll(statement);
        System.out.println("***************"+obj.getData());
        return obj;
    }

    //审批工作计划
    @PostMapping("/spStatement")
    public ReturnObj spStatement(@RequestBody TbStatement statement, @RequestParam("emp_id") Long emp_id){
        System.out.println("=====================2077"+statement);
        ReturnObj obj = statementService.sqStatement(statement,emp_id);
        return obj;
    }

    @PostMapping("/insertStatement")
    public ReturnObj insertStatement( @RequestBody TbStatement statement, @RequestParam("cemps") List<Long> cemps,
                                 @RequestParam("statement_schedulings")String[] statement_schedulings) {
        List<TbStatementScheduling> schedulings = new ArrayList<>();
        for (int i=0;i<statement_schedulings.length;i++){
            TbStatementScheduling tbStatementScheduling = new TbStatementScheduling();
            tbStatementScheduling.setScheduling(statement_schedulings[i]);
            schedulings.add(tbStatementScheduling);
        }
        return statementService.insertStatement(statement,cemps,schedulings);
    }

    @PostMapping("/updStatement")
    public ReturnObj updStatement(@RequestBody TbStatement statement) {
        int i = statementService.updStatement(statement);
        if (i==0){
            return new ReturnObj(400,"操作失败",i,null);
        }
        return new ReturnObj(200,"操作成功",i,i);
    }

    @DeleteMapping("/delStatement")
    public ReturnObj delStatement(@RequestParam("planId") Long statementId) {
        int i = statementService.delStatement(statementId);
        if (i==0){
            return new ReturnObj(400,"操作失败",i,null);
        }
        return new ReturnObj(200,"操作成功",i,i);
    }

    @GetMapping("/selStatementTypes")
    public ReturnObj selStatementTypes() {
        List<TbStatementType> tbStatementTypes = statementService.selStatementTypes();
        if (null==tbStatementTypes){
            return new ReturnObj(400,"查询失败",null,tbStatementTypes);
        }
        return new ReturnObj(200,"查询成功",tbStatementTypes.size(),tbStatementTypes);
    }

}
