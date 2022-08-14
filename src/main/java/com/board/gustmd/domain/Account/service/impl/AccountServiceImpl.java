package com.board.gustmd.domain.Account.service.impl;

import com.board.gustmd.domain.Account.data.dto.request.RegisterRequest;
import com.board.gustmd.domain.Account.data.dto.response.TokenResponse;
import com.board.gustmd.domain.Account.service.AccountService;
import com.board.gustmd.domain.Account.utils.AuthValidator;
import com.board.gustmd.domain.user.data.entity.User;
import com.board.gustmd.domain.user.repository.UserRepository;
import com.board.gustmd.global.security.jwt.JwtTokenProvider;
import com.board.gustmd.global.user.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthValidator authValidator;
    private final UserUtils userUtils;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    @Transactional
    public void register(RegisterRequest registerRequest) {
        userUtils.checkExistsEmail(registerRequest.getEmail());
        userUtils.checkExistName(registerRequest.getName());
        User user=registerRequest.toEntity(passwordEncoder);
        userRepository.save(user);
    }

    @Override
    public TokenResponse login(String email) {
        User user = userUtils.getUserByEmail(email);
        String access = jwtTokenProvider.generateAccessToken(email);
        String refresh = jwtTokenProvider.generateRefreshToken(email);
        Integer accessExp = 60 * 15;
        Integer refreshExp = 60*60*24*7;
        user.updateRefreshToken(refresh);

        return new TokenResponse(access,refresh,accessExp,refreshExp);
    }

    @Override
    public void logout() {

    }

    @Override
    public void refresh() {

    }
}
