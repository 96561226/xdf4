package com.aaa.springcloud.service.finance;

import com.aaa.pojo.Emp;
import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.finance.SearchIncome;
import com.aaa.pojo.finance.TbGathering;
import com.aaa.pojo.finance.TbPaymentType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Component
@FeignClient(value = "XDF4-PROVIDER-FINANCE",contextId = "IncomeId")
public interface IncomeService {
    @RequestMapping("/income/all")
    public ReturnObj selectTravelingAll(@RequestBody SearchIncome income);
    @GetMapping("/income/empAndDept")
    public ReturnObj selectAllEmp();
}
