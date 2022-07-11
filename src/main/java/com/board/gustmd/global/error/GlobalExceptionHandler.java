package com.board.gustmd.global.error;

import com.board.gustmd.global.error.exception.ErrorCode;
import com.board.gustmd.global.error.exception.GlobalException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(GlobalException e){
        ErrorCode errorCode =e.getErrorCode();
        return new ResponseEntity<>(new ErrorResponse(errorCode.getStatus(),errorCode.getMessage()),
                                    HttpStatus.valueOf(errorCode.getStatus()));
    }
}
