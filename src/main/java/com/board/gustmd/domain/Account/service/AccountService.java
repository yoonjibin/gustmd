package com.board.gustmd.domain.Account.service;

import com.board.gustmd.domain.Account.data.dto.request.RegisterRequest;
import com.board.gustmd.domain.Account.data.dto.response.TokenResponse;

public interface AccountService {
     void register(RegisterRequest registerRequest);
     TokenResponse login(String email);
     void logout();
     void refresh();
}
