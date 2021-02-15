package com.aaa.service.impl;

import com.aaa.mapper.TransactionMapper;
import com.aaa.pojo.Transaction;
import com.aaa.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionMapper transactionMapper;
    @Override
    public int insert(Transaction record) {
        return transactionMapper.insert(record);
    }

    @Override
    public int delTrasaction(Long tid) {
        return transactionMapper.delTrasaction(tid);
    }

    @Override
    public int updTrasaction(Transaction transaction) {
        return transactionMapper.updTrasaction(transaction);
    }

    @Override
    public List<Transaction> selectAll() {
        return transactionMapper.selectAll();
    }

    @Override
    public List<Transaction> selectByLoginNo(String empNo) {
        return transactionMapper.selectByLoginNo(empNo);
    }

    @Override
    public List<Transaction> selectByRoleId(Long role_id) {
        return transactionMapper.selectByRoleId(role_id);
    }
}
