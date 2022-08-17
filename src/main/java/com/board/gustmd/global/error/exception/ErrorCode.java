package com.board.gustmd.global.error.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {
    BOARD_NOT_FOUND(404,"Board Not Found"),
    ALREADY_EXIST_EMAIL(400,"Already Exist Email"),
    PASSWORD_MISMATCH(400,"PasswordMismatch"),
    ALREADY_EXIST_NAME(400,"Already Exist Name"),
    NOT_THE_OWNER(400,"Not The Owner"),
    EXPIRED_TOKEN(401,"Expired Token"),
    INVALID_TOKEN(401, "Invalid Token"),
    UNAUTHORIZED(401, "Unauthorized"),
    USER_NOT_FOUND(404,"User Not Found");

    private final int status;
    private final String message;
}
