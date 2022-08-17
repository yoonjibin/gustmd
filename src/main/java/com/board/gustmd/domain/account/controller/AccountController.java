package com.board.gustmd.domain.account.controller;

import com.board.gustmd.domain.account.data.dto.request.LoginRequest;
import com.board.gustmd.domain.account.data.dto.request.RegisterRequest;
import com.board.gustmd.domain.account.data.dto.response.TokenResponse;
import com.board.gustmd.domain.account.service.AccountService;
import com.board.gustmd.domain.account.utils.AuthValidator;
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

    @PostMapping("/register")
    public ResponseEntity<Void>register(@RequestBody RegisterRequest registerRequest){
        accountService.register(registerRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse>login(@RequestBody LoginRequest loginRequest){
        String validatedEmail = authValidator.validateUser(loginRequest.getEmail(), loginRequest.getPassword());
        TokenResponse tokenData = accountService.login(validatedEmail);
        return new ResponseEntity<>(tokenData,HttpStatus.OK);
    }
    @PatchMapping("/logout")
    public ResponseEntity<Void>logout(){
        accountService.logout();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("/refresh")
    public ResponseEntity<TokenResponse>refresh(@RequestHeader("Refresh-Token")String refreshToken){
        TokenResponse tokenData = accountService.refresh(refreshToken);
        return new ResponseEntity<>(tokenData,HttpStatus.OK);
    }
    @PostMapping("/withdrawal")
    public ResponseEntity<Void>withdrawal(){
        accountService.withdrawal();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
