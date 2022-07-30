package com.board.gustmd.global.user.exception;

import com.board.gustmd.global.error.exception.ErrorCode;
import com.board.gustmd.global.error.exception.GlobalException;

public class AlreadyExistNameException extends GlobalException {

    public AlreadyExistNameException() {
        super(ErrorCode.ALREADY_EXIST_NAME);
    }
}
