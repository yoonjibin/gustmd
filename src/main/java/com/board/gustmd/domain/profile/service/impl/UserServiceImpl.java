package com.board.gustmd.domain.profile.service.impl;

import com.board.gustmd.domain.profile.data.dto.request.UpdateProfileRequest;
import com.board.gustmd.domain.profile.data.dto.response.ExractMyProfileResponse;
import com.board.gustmd.domain.profile.data.entity.User;
import com.board.gustmd.domain.profile.repository.UserRepository;
import com.board.gustmd.domain.profile.service.UserService;
import com.board.gustmd.global.board.BoardUtils;
import com.board.gustmd.global.user.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserUtils userUtils;
    private final BoardUtils boardUtils;
    private final UserRepository userRepository;

    @Override
    public ExractMyProfileResponse exractMyProfile() {
         User userInfo = userUtils.getCurrentUser();
         List<String> boardInfo = boardList(userInfo);
         return new ExractMyProfileResponse(userInfo.getName(),userInfo.getEmail(),boardInfo);
    }

    @Override
    @Transactional
    public void updateProfile(UpdateProfileRequest updateProfileRequest) {
        User user = userUtils.getCurrentUser();
        user.update(updateProfileRequest.getName());
    }

    private List<String> boardList(User userInfo){
        return boardUtils.findBoardsByUserInfo(userInfo);
    }
}
