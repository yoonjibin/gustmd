package com.board.gustmd.domain.Account.service;

import com.board.gustmd.domain.Account.data.dto.request.RegisterRequest;

public interface AccountService {
     void register(RegisterRequest registerRequest);
     void login();
     void logout();
     void refresh();
}
