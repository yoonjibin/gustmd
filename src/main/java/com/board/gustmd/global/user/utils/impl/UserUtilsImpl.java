package com.board.gustmd.global.user.utils.impl;

import com.board.gustmd.global.user.exception.AlreadyExistEmailException;
import com.board.gustmd.global.user.exception.AlreadyExistNameException;
import com.board.gustmd.domain.profile.data.entity.User;
import com.board.gustmd.domain.profile.repository.UserRepository;
import com.board.gustmd.global.user.exception.UserNotFountException;
import com.board.gustmd.global.user.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUtilsImpl implements UserUtils {
    private final UserRepository userRepository;
    @Override
    public User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByEmail(email);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(UserNotFountException::new);
    }

    @Override
    public void checkExistName(String name) {
        if(userRepository.existsByName(name)) throw new AlreadyExistNameException ();
    }

    @Override
    public void checkExistsEmail(String email) {
        if(userRepository.existsById(email)) throw new AlreadyExistEmailException ();
    }
}
