package com.board.gustmd.domain.profile.service;

import com.board.gustmd.domain.profile.data.dto.request.UpdateProfileRequest;
import com.board.gustmd.domain.profile.data.dto.response.ExractMyProfileResponse;

public interface UserService {
    ExractMyProfileResponse exractMyProfile();
    void updateProfile(UpdateProfileRequest updateProfileRequest);
}
