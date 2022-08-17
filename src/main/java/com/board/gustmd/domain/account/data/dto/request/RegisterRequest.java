package com.board.gustmd.domain.account.data.dto.request;

import com.board.gustmd.domain.profile.data.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@RequiredArgsConstructor
public class RegisterRequest {
    private final String email;
    private final String password;
    private final String name;

    public User toEntity(PasswordEncoder passwordEncoder){
        return User.builder().email(email).password(passwordEncoder.encode(password)).name(name).build();
    }
}
