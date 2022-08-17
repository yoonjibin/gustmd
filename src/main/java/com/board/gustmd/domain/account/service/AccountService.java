package com.board.gustmd.domain.account.service;

import com.board.gustmd.domain.account.data.dto.request.RegisterRequest;
import com.board.gustmd.domain.account.data.dto.response.TokenResponse;

public interface AccountService {
     void register(RegisterRequest registerRequest);
     TokenResponse login(String email);
     void logout();
     TokenResponse refresh(String refreshToken);
     void withdrawal();
}
