package com.example.hospitalward.service.impl;

import com.example.hospitalward.mapper.custom.AccountCustomerMapper;
import com.example.hospitalward.model.Account;
import com.example.hospitalward.model.Patient;
import com.example.hospitalward.service.AccountService;
import com.example.hospitalward.util.Page;
import com.example.hospitalward.util.SnowflakeIdWorker;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountCustomerMapper accountCustomerMapper;
    @Override
    public PageInfo selectList(Patient patient, Page page) {
        if(page!=null && page.getPageNum()!=null && page.getPageSize()!=null){
            PageHelper.startPage(page.getPageNum(), page.getPageSize());
        }
        List<Account> accounts = accountCustomerMapper.selectList(patient, page);
        PageInfo<Account> pageInfo = new PageInfo<>(accounts);
        return pageInfo;
    }

    @Override
    public Integer create(Account account) throws Exception {
        account.setId(SnowflakeIdWorker.getUUID());
        account.setIsDeleted(false);
        account.setCreateDate(new Date());
        account.setUpdateDate(new Date());
        account.setPayDate(new Date());
        int result = accountCustomerMapper.insertSelective(account);
        return result;
    }

    @Override
    public Integer edit(Account account) throws Exception {
        Account updataAccount = new Account();
        updataAccount.setId(account.getId());
        updataAccount.setDeposit(account.getDeposit() + account.getComplement());
        updataAccount.setIsDeleted(false);
        updataAccount.setUpdateDate(new Date());
        updataAccount.setPayDate(new Date());
        int result = accountCustomerMapper.updateByPrimaryKeySelective(updataAccount);
        return result;
    }
}
