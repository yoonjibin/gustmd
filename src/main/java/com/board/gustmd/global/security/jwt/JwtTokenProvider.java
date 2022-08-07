package com.board.gustmd.global.security.jwt;

import com.board.gustmd.global.security.auth.AuthDetailService;
import com.board.gustmd.global.security.properties.JwtProperties;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {
    private final JwtProperties jwtProperties;
    private final AuthDetailService authDetailService;

    private String generateToken(String email,String type,String secret,Integer exp){
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encodeToString(secret.getBytes()))
                .claim("email",email)
                .claim("type",type)
                .setIssuedAt(new Date())
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + exp * 1000))
                .compact();
    }

    private String generateAccessToken(String email){
        return generateToken(email,"access",jwtProperties.getAccessSecret(),60*15);
    }
    private String generateRefreshToken(String email){
        return generateToken(email,"refresh",jwtProperties.getRefreshSecret(),60*60*24*7);
    }
}
