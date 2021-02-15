package com.aaa.springcloud.controller.plan;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.plans.TbStatement;
import com.aaa.searchpojo.SearchStatement;
import com.aaa.springcloud.service.api.FormService;
import com.aaa.springcloud.service.objectplan.StatementService;
import com.aaa.springcloud.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class StatementController extends BaseController {
    @Autowired
    StatementService statementService;
    @Autowired
    FormService formService;
    @RequestMapping("/consumer/statement/statements")
    public ReturnObj selectAll(SearchStatement statement){
        return statementService.selectAll(statement);
    };
    @RequestMapping(value = "/consumer/statement/statementNo")
    public ReturnObj statementNo(){
        return formService.selno("BG-","tb_statement","statement_id");
    }



    //审批工作计划
    @PostMapping("/consumer/statement/spStatement")
    public ReturnObj spStatement(TbStatement statement){
        Authentication au = SecurityContextHolder.getContext().getAuthentication();
        Object[] array = au.getAuthorities().toArray();

        Long emp_id = Long.valueOf(array[0].toString()) ;

        if (null==emp_id || null==statement.getStatement_id() ||null==statement.getState()){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        return statementService.spStatement(statement,emp_id);
    };

    @PostMapping("/consumer/statement/insertStatement")
    public ReturnObj insertStatement(TbStatement statement,String[] charge_emps,String[] statement_schedulings){
        Authentication au = SecurityContextHolder.getContext().getAuthentication();
        Object[] array = au.getAuthorities().toArray();

        Long emp_id = Long.valueOf(array[0].toString()) ;
        statement.setEmp_id(emp_id);
        List<Long> emps = new ArrayList<>();
        for (String cemp : charge_emps) {
            emps.add(Long.valueOf(cemp));
        }
        return statementService.insertStatement(statement,emps,statement_schedulings);
    };

    @PostMapping("/consumer/statement/updStatement")
    public ReturnObj updStatement(TbStatement statement){
        return statementService.updStatement(statement);
    };

    @DeleteMapping("/consumer/statement/delStatement")
    public ReturnObj delStatement(Long statementId){
        return statementService.delStatement(statementId);
    } ;

    @GetMapping("/consumer/statement/selStatementTypes")
    public ReturnObj selStatementTypes(){
        return statementService.selStatementTypes();
    } ;
}
