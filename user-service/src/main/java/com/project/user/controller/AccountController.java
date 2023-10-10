package com.project.user.controller;

import com.project.user.entity.Account;
import com.project.user.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class AccountController {

    @Resource
    private IAccountService accountService;

    @GetMapping("/{id}")
    public Account queryByID(@PathVariable("id") Long id){
        return accountService.queryByID(id);
    }



}
