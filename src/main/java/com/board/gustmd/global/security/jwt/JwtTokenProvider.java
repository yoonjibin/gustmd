package com.board.gustmd.global.security.jwt;

import com.board.gustmd.global.security.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
    private final JwtProperties jwtProperties;


}
