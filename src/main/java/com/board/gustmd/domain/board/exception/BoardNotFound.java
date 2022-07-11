package com.board.gustmd.domain.board.exception;

import com.board.gustmd.global.error.exception.ErrorCode;
import com.board.gustmd.global.error.exception.GlobalException;

public class BoardNotFound extends GlobalException {
    public BoardNotFound() {
        super(ErrorCode.BOARD_NOT_FOUND);
    }
}
