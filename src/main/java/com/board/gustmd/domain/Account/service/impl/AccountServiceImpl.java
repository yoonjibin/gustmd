package com.board.gustmd.domain.Account.service.impl;

import com.board.gustmd.domain.Account.data.dto.request.RegisterRequest;
import com.board.gustmd.domain.Account.service.AccountService;
import com.board.gustmd.domain.user.data.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AccountServiceImpl implements AccountService {
    @Override
    public void register(RegisterRequest registerRequest) {
        User user=new User();
    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }

    @Override
    public void refresh() {

    }
}
