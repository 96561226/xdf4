package com.aaa.springcloud.service.objectplan;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.plans.TbStatement;
import com.aaa.pojo.plans.TbStatementScheduling;
import com.aaa.pojo.plans.TbStatementType;
import com.aaa.searchpojo.SearchStatement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Component
@FeignClient(value = "XDF4-PROVIDE-OBJECTPLAN",contextId = "statementId")
public interface StatementService {
    @RequestMapping("/statement/statements")
    public ReturnObj selectAll(@RequestBody SearchStatement statement);

    //审批工作计划
    @PostMapping("/statement/spStatement")
    public ReturnObj spStatement(@RequestBody TbStatement statement, @RequestParam("emp_id") Long emp_id);

    @PostMapping("/statement/insertStatement")
    public ReturnObj insertStatement( @RequestBody TbStatement statement, @RequestParam("cemps") List<Long> cemps,
                                      @RequestParam("statement_schedulings")String[] statement_schedulings);

    @PostMapping("/statement/updStatement")
    public ReturnObj updStatement(@RequestBody TbStatement statement);

    @DeleteMapping("/statement/delStatement")
    public ReturnObj delStatement(@RequestParam("planId") Long statementId) ;

    @GetMapping("/statement/selStatementTypes")
    public ReturnObj selStatementTypes() ;
}
