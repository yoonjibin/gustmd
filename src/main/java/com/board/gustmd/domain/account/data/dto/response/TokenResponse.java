package com.board.gustmd.domain.account.data.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TokenResponse {
    private final String accessToken;
    private final String refreshToken;
    private final Integer accessExp;
    private final Integer refreshExp;
}
