package com.aaa.springcloud.controller.systemmaster;

import com.aaa.pojo.ReturnObj;
import com.aaa.pojo.Transaction;
import com.aaa.springcloud.service.systemmaster.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping("/ts/insert")
    public ReturnObj insert(Transaction record){
        if (null == record){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        int insert = transactionService.insert(record);
        if (insert>0){
            return new ReturnObj(200,"添加成功",insert,record);
        }
        return new ReturnObj(400,"添加失败",null,null);
    };

    @DeleteMapping("/ts/delTrasaction")
    public ReturnObj delTrasaction(Long tid){
        if (null == tid){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        int i = transactionService.delTrasaction(tid);
        if (i>0){
            return new ReturnObj(200,"删除成功",i,tid);
        }
        return new ReturnObj(400,"删除失败",null,null);
    };

    @PostMapping("/ts/updTrasaction")
    public ReturnObj updTrasaction(Transaction transaction){
        if (null == transaction){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        int i = transactionService.updTrasaction(transaction);
        if (i>0){
            return new ReturnObj(200,"修改成功",i,transaction);
        }
        return new ReturnObj(400,"修改失败",null,null);
    };

    @GetMapping("/ts/selectAll")
    public ReturnObj selectAll(){
        List<Transaction> transactions = transactionService.selectAll();
        if (null==transactions){
            return new ReturnObj(400,"查询失败",null,null);
        }
        return new ReturnObj(200,"查询成功",transactions.size(),transactions);
    };

    @GetMapping("/ts/selectByRoleId")
    public ReturnObj selectByRoleId(Long role_id){
        if (null==role_id){
            return new ReturnObj(400,"缺失参数",null,null);
        }
        List<Transaction> transactions = transactionService.selectByRoleId(role_id);
        if (null==transactions){
            return new ReturnObj(400,"查询失败",null,role_id);
        }
        return new ReturnObj(200,"查询成功",transactions.size(),transactions);
    };
}
