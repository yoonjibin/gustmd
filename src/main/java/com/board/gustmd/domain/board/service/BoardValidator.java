package com.board.gustmd.domain.board.service;

import com.board.gustmd.domain.board.data.entity.Board;
import com.board.gustmd.domain.user.data.entity.User;

public interface BoardValidator {
    void validate(User userInfo, Board boardInfo);
}
