package com.board.gustmd.domain.Account.data.dto.request;

import com.board.gustmd.domain.user.data.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RegisterRequest {
    private final String email;
    private final String password;
    private final String name;

    public User toEntity(String encodedPassword){
        return User.builder().email(email).password(encodedPassword).name(name).build();
    }
}
