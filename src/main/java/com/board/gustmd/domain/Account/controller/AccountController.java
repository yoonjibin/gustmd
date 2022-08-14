package com.board.gustmd.domain.Account.controller;

import com.board.gustmd.domain.Account.data.dto.request.LoginRequest;
import com.board.gustmd.domain.Account.data.dto.request.RegisterRequest;
import com.board.gustmd.domain.Account.data.dto.response.TokenResponse;
import com.board.gustmd.domain.Account.service.AccountService;
import com.board.gustmd.domain.Account.utils.AuthValidator;
import com.board.gustmd.global.user.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;
    private final AuthValidator authValidator;

    @PostMapping("register")
    public ResponseEntity<Void>register(@RequestBody RegisterRequest registerRequest){
        accountService.register(registerRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse>login(@RequestBody LoginRequest loginRequest){
        String ValidatedEmail = authValidator.ValidateUser(loginRequest.getEmail(), loginRequest.getPassword());

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("logout")
    public ResponseEntity<Void>logout(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("refresh")
    public ResponseEntity<Void>refresh(){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
