package com.board.gustmd.domain.Account.utils.impl;

import com.board.gustmd.domain.Account.exception.PasswordMismatchException;
import com.board.gustmd.domain.Account.utils.AuthValidator;
import com.board.gustmd.domain.user.data.entity.User;
import com.board.gustmd.global.user.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthValidatorImpl implements AuthValidator {
    private final PasswordEncoder passwordEncoder;
    private final UserUtils userUtils;
    @Override
    public String ValidateUser(String email, String password) {
        User user = userUtils.getUserByEmail(email);
        userUtils.checkExistName(email);
        if(!passwordEncoder.matches(password,user.getPassword())) throw new PasswordMismatchException();
        return email;
    }
}
