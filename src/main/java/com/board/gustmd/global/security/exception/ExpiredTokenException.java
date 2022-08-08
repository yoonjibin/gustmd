package com.board.gustmd.global.security.exception;

import com.board.gustmd.global.error.exception.ErrorCode;
import com.board.gustmd.global.error.exception.GlobalException;

public class ExpiredTokenException extends GlobalException {
    public ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
