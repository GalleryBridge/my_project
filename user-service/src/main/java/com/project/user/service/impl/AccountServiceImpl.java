package com.project.user.service.impl;

import com.project.user.entity.Account;
import com.project.user.mapper.AccountMapper;
import com.project.user.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AccountServiceImpl implements IAccountService {

    @Resource
    private AccountMapper accountMapper;

    @Override
    public Account queryByID(Long id) {
        return accountMapper.findById(id);
    }
}
