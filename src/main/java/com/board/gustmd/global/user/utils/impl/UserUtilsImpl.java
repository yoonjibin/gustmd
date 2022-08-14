package com.board.gustmd.global.user.utils.impl;

import com.board.gustmd.global.user.exception.AlreadyExistEmailException;
import com.board.gustmd.global.user.exception.AlreadyExistNameException;
import com.board.gustmd.domain.user.data.entity.User;
import com.board.gustmd.domain.user.repository.UserRepository;
import com.board.gustmd.global.user.exception.UserNotFountException;
import com.board.gustmd.global.user.utils.UserUtils;

public class UserUtilsImpl implements UserUtils {
    private UserRepository userRepository;
    @Override
    public User getCurrentUser() {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(UserNotFountException::new);
    }

    @Override
    public void checkExistName(String name) {
        if(userRepository.existsByName(name)){
            throw new AlreadyExistNameException();
        }
    }

    @Override
    public void checkExistsEmail(String email) {
        if(userRepository.existsById(email)){
            throw new AlreadyExistEmailException();
        }
    }
}
