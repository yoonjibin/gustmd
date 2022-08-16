package com.board.gustmd.domain.user.service.impl;

import com.board.gustmd.domain.user.data.dto.response.ExractMyProfileResponse;
import com.board.gustmd.domain.user.data.entity.User;
import com.board.gustmd.domain.user.service.UserService;
import com.board.gustmd.global.board.BoardUtils;
import com.board.gustmd.global.user.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserUtils userUtils;
    private final BoardUtils boardUtils;

    @Override
    public ExractMyProfileResponse exractMyProfile() {
         User userInfo = userUtils.getCurrentUser();
         List<String> boardInfo = boardList(userInfo);
         return new ExractMyProfileResponse(userInfo.getName(),userInfo.getEmail(),boardInfo);
    }
    private List<String> boardList(User userInfo){
        return boardUtils.findBoardsByUserInfo(userInfo);
    }
}
