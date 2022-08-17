package com.board.gustmd.domain.user.controller;

import com.board.gustmd.domain.user.data.dto.request.UpdateProfileRequest;
import com.board.gustmd.domain.user.data.dto.response.ExractMyProfileResponse;
import com.board.gustmd.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;


    @GetMapping("my")
    public ResponseEntity<ExractMyProfileResponse> exractMyProfile(){
        ExractMyProfileResponse response =  userService.exractMyProfile();
        return new ResponseEntity(response, HttpStatus.OK);
    };

    @PutMapping
    public ResponseEntity<Void>UpdateProfile(@RequestBody UpdateProfileRequest updateProfileRequest){
        userService.updateProfile(updateProfileRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
