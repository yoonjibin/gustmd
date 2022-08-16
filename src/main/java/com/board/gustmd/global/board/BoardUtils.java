package com.board.gustmd.global.board;

import com.board.gustmd.domain.user.data.entity.User;

import java.util.List;

public interface BoardUtils {
    List findBoardsByUserInfo(User userInfo);
}
