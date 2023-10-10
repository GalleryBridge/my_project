package com.project.user.service;

import com.project.user.entity.Account;
import org.springframework.web.bind.annotation.PathVariable;

public interface IAccountService {
    public Account queryByID(Long id);
}
