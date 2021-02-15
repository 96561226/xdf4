package com.aaa.controller;

import com.aaa.pojo.Transaction;
import com.aaa.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ts")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/insert")
    public int insert(@RequestBody Transaction record) {
        return transactionService.insert(record);
    }

    @DeleteMapping("/delTrasaction")
    public int delTrasaction(@RequestParam("tid") Long tid) {
        return transactionService.delTrasaction(tid);
    }

    @PostMapping("/updTrasaction")
    public int updTrasaction(@RequestBody Transaction transaction) {
        return transactionService.updTrasaction(transaction);
    }

    @GetMapping("/selectAll")
    public List<Transaction> selectAll() {
        return transactionService.selectAll();
    }

    @GetMapping("/selectByLoginNo")
    public List<Transaction> selectByLoginNo(@RequestParam("empNo") String empNo) {
        return transactionService.selectByLoginNo(empNo);
    }

    @GetMapping("/selectByRoleId")
    public List<Transaction> selectByRoleId(@RequestParam("role_id")Long role_id) {
        return transactionService.selectByRoleId(role_id);
    }
}
