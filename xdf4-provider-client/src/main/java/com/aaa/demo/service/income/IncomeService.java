package com.aaa.demo.service.income;

import com.aaa.pojo.*;
import com.aaa.pojo.finance.TbIncome;
import com.aaa.searchpojo.SearchEmp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(value = "XDF4-PROVIDER-FINANCE",contextId = "IncomeId")
public interface IncomeService {
    //新增收支登记
    @PostMapping("/income/addIncome")
    ReturnObj addIncome(@RequestBody TbIncome income);

}
