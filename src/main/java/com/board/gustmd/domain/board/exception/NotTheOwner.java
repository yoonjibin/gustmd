package com.board.gustmd.domain.board.exception;

import com.board.gustmd.global.error.exception.ErrorCode;
import com.board.gustmd.global.error.exception.GlobalException;

public class NotTheOwner extends GlobalException {
    public NotTheOwner() {
        super(ErrorCode.NOT_THE_OWNER);
    }
}
