package com.board.gustmd.global.security.exception;

import com.board.gustmd.global.error.exception.ErrorCode;
import com.board.gustmd.global.error.exception.GlobalException;

public class InvalidTokenException extends GlobalException {

    public InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
