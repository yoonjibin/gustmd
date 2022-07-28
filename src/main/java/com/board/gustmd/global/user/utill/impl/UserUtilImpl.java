package com.board.gustmd.global.user.utill.impl;

import com.board.gustmd.domain.user.repository.UserRepository;
import com.board.gustmd.global.user.exception.AlreadyExistEmailException;
import com.board.gustmd.global.user.utill.UserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserUtilImpl implements UserUtil {
   private final UserRepository userRepository;

    @Override
    public void checkExistsEmail(String email) {
        if(userRepository.existsById(email)){
            throw new AlreadyExistEmailException();
        }
    }
}
