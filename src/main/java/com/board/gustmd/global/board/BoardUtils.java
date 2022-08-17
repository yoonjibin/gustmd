package com.board.gustmd.global.board;

import com.board.gustmd.domain.board.data.entity.Board;
import com.board.gustmd.domain.profile.data.entity.User;

import java.util.List;

public interface BoardUtils {
    List findBoardsByUserInfo(User userInfo);
    void validate(User userInfo, Board boardInfo);
}
