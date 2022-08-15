package com.board.gustmd.global.security.jwt;

import com.board.gustmd.global.security.auth.AuthDetailService;
import com.board.gustmd.global.security.exception.ExpiredTokenException;
import com.board.gustmd.global.security.exception.InvalidTokenException;
import io.jsonwebtoken.*;
import com.board.gustmd.global.security.properties.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@Slf4j
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

    public String generateAccessToken(String email){
        return generateToken(email,"access",jwtProperties.getAccessSecret(),60*15);
    }
    public String generateRefreshToken(String email){
        return generateToken(email,"refresh",jwtProperties.getRefreshSecret(),60*60*24*7);
    }
    public Authentication getAuthentication(String token){
        UserDetails userDetails = authDetailService.loadUserByUsername(getTokenSubject(token,jwtProperties.getAccessSecret()));
        return new UsernamePasswordAuthenticationToken(userDetails,"",userDetails.getAuthorities());
    }
    private Claims getTokenBody(String token, String secret){
        try{
            return Jwts.parser()
                    .setSigningKey(Base64.getEncoder().encodeToString(secret.getBytes()))
                    .parseClaimsJws(token)
                    .getBody();
        }catch(ExpiredJwtException e){
            throw new ExpiredTokenException();
        }catch(MalformedJwtException | SignatureException e){
            throw new InvalidTokenException();
        }
    }
    public String resolveToken(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if((token != null) && token.startsWith ("Bearer "))
            return token.replace ("Bearer ", "");
        return null;
    }
    private String getTokenSubject(String token,String secret){
        return getTokenBody(token,secret).get("email",String.class);
    }
    public String exactEmailFromRefreshToken(String token){
        String refresh = token.replace("Bearer ","");
        return getTokenSubject(refresh,jwtProperties.getRefreshSecret());
    }
}
