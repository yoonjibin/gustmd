package com.board.gustmd.domain.Account.service;

import com.board.gustmd.domain.Account.data.dto.request.RegisterRequest;

public interface AccountService {
    public void register(RegisterRequest registerRequest);
    public void login();
    public void logout();
    public void refresh();
}
