package com.board.gustmd.domain.auth.data.dto.request;

import lombok.Data;

@Data
public class RegisterInfoRequest {
    private String email;
    private String password;
}
