package com.board.gustmd.domain.account.service.impl;

import com.board.gustmd.domain.account.data.dto.request.RegisterRequest;
import com.board.gustmd.domain.account.data.dto.response.TokenResponse;
import com.board.gustmd.domain.account.service.AccountService;
import com.board.gustmd.domain.user.data.entity.User;
import com.board.gustmd.domain.user.repository.UserRepository;
import com.board.gustmd.global.security.exception.InvalidTokenException;
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
    @Transactional
    public TokenResponse login(String email) {
        return getTokenResponseToLogin(email);
    }

    @Override
    @Transactional
    public void logout() {
        User user = userUtils.getCurrentUser();
        user.updateRefreshToken(null);
    }

    @Override
    public TokenResponse refresh(String refreshToken) {
        String email = jwtTokenProvider.exractEmailFromRefreshToken(refreshToken);
        User user = userUtils.getUserByEmail(email);
        if(!refreshToken.equals(user.getRefreshToken())) throw new InvalidTokenException();
        return getTokenResponseByRefreshToken(email,user);
    }

    @Override
    public void withdrawal() {
        User userInfo = userUtils.getCurrentUser();
        userRepository.delete(userInfo);
    }

    private TokenResponse getTokenResponseToLogin(String email) {
        User user = userUtils.getUserByEmail(email);
        return getTokenResponse(email, user);
    }

    private TokenResponse getTokenResponse(String email, User user) {
        String access = jwtTokenProvider.generateAccessToken(email);
        String refresh = jwtTokenProvider.generateRefreshToken(email);
        Integer accessExp = 60 * 15;
        Integer refreshExp = 60*60*24*7;
        user.updateRefreshToken(refresh);

        return new TokenResponse(access,refresh,accessExp,refreshExp);
    }

    private TokenResponse getTokenResponseByRefreshToken(String email,User user){
        return getTokenResponse(email, user);
    }
}
