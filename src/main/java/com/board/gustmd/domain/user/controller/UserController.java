package com.board.gustmd.domain.user.controller;

import com.board.gustmd.domain.user.data.dto.response.ExractMyProfileResponse;
import com.board.gustmd.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {
    private final UserService userService;


    @GetMapping
    public ResponseEntity<ExractMyProfileResponse> exractMyProfile(){
        ExractMyProfileResponse response =  userService.exractMyProfile();
        return new ResponseEntity(response, HttpStatus.OK);
    };
}
