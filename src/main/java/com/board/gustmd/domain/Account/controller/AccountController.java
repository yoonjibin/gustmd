package com.board.gustmd.domain.Account.controller;

import com.board.gustmd.domain.Account.data.dto.request.RegisterRequest;
import com.board.gustmd.domain.Account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @PostMapping("register")
    public ResponseEntity<Void>register(RegisterRequest registerRequest){
        accountService.register(registerRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Void>login(){
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
