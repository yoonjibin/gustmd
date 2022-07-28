package com.board.gustmd.global.user.exception;

import com.board.gustmd.global.error.exception.ErrorCode;
import com.board.gustmd.global.error.exception.GlobalException;

public class AlreadyExistEmailException extends GlobalException {

    public AlreadyExistEmailException() {
        super(ErrorCode.ALREADY_EXIST_EMAIL);
    }
}
