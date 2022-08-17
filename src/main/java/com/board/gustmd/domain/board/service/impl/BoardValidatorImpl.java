package com.board.gustmd.domain.board.service.impl;

import com.board.gustmd.domain.board.data.entity.Board;
import com.board.gustmd.domain.board.exception.NotTheOwner;
import com.board.gustmd.domain.board.repository.BoardRepository;
import com.board.gustmd.domain.board.service.BoardValidator;
import com.board.gustmd.domain.user.data.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardValidatorImpl implements BoardValidator {
    private final BoardRepository boardRepository;
    @Override
    public void validate(User userInfo, Board boardInfo) {
        boolean checkBoardOwner = boardRepository.existsByUserAndTitle(userInfo,boardInfo.getTitle());
        if(!checkBoardOwner) throw new NotTheOwner ();
    }
}
