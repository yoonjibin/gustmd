package com.board.gustmd.domain.user.service;

import com.board.gustmd.domain.user.data.dto.request.UpdateProfileRequest;
import com.board.gustmd.domain.user.data.dto.response.ExractMyProfileResponse;

public interface UserService {
    ExractMyProfileResponse exractMyProfile();
    void updateProfile(UpdateProfileRequest updateProfileRequest);
}
