package com.board.gustmd.domain.Account.service.impl;

import com.board.gustmd.domain.Account.data.dto.request.RegisterRequest;
import com.board.gustmd.domain.Account.service.AccountService;
import com.board.gustmd.domain.user.data.entity.User;
import com.board.gustmd.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void register(RegisterRequest registerRequest) {
        User user=registerRequest.toEntity(passwordEncoder.encode(registerRequest.getPassword()));
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
