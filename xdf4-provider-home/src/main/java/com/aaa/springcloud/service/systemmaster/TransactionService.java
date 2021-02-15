package com.aaa.springcloud.service.systemmaster;

import com.aaa.pojo.Transaction;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
@FeignClient(value = "XDF4-API-DAO",contextId = "transactionId")
public interface TransactionService {
    @PostMapping("/ts/insert")
    public int insert(@RequestBody Transaction record);

    @DeleteMapping("/ts/delTrasaction")
    public int delTrasaction(@RequestParam("tid") Long tid);

    @PostMapping("/ts/updTrasaction")
    public int updTrasaction(@RequestBody Transaction transaction);

    @GetMapping("/ts/selectAll")
    public List<Transaction> selectAll();

    @GetMapping("/ts/selectByLoginNo")
    public List<Transaction> selectByLoginNo(@RequestParam("empNo") String empNo);

    @GetMapping("/ts/selectByRoleId")
    public List<Transaction> selectByRoleId(@RequestParam("role_id")Long role_id);
}
