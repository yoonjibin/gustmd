package com.board.gustmd.global.user.utils;

import com.board.gustmd.domain.user.data.entity.User;

public interface UserUtils {
    User getCurrentUser();
    User getUserByEmail(String email);
    void checkExistName(String name);
    void checkExistsEmail(String email);
}
