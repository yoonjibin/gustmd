package com.board.gustmd.global.user.exception;

import com.board.gustmd.global.error.exception.ErrorCode;
import com.board.gustmd.global.error.exception.GlobalException;

public class UserNotFoundException extends GlobalException {
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
