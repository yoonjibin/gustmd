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
    USER_NOT_FOUND(404,"User Not Found"),
    ALREADY_EXIST_NAME(400,"Already Exist Name");

    private final int status;
    private final String message;
}
