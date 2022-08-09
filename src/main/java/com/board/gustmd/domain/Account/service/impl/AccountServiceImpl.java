package com.board.gustmd.domain.Account.service.impl;

import com.board.gustmd.domain.Account.data.dto.request.RegisterRequest;
import com.board.gustmd.domain.Account.service.AccountService;
import com.board.gustmd.domain.user.data.entity.User;
import com.board.gustmd.domain.user.repository.UserRepository;
import com.board.gustmd.global.user.utill.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserUtil userUtil;

    @Override
    @Transactional
    public void register(RegisterRequest registerRequest) {
        userUtil.checkExistsEmail(registerRequest.getEmail());
        userUtil.checkExistName(registerRequest.getName());
        User user=registerRequest.toEntity(passwordEncoder.encode(registerRequest.getPassword()));
        userRepository.save(user);
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
