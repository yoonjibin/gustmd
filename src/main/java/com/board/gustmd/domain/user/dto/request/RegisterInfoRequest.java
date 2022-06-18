package com.board.gustmd.domain.auth.user.dto.request;

import lombok.Data;

@Data
public class RegisterInfoRequest {
    private String email;
    private String password;
}
