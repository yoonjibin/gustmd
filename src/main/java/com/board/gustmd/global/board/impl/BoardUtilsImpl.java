package com.board.gustmd.global.board.impl;

import com.board.gustmd.domain.board.data.dto.response.MyPageBoardResponse;
import com.board.gustmd.domain.board.data.entity.Board;
import com.board.gustmd.domain.board.exception.NotTheOwner;
import com.board.gustmd.domain.board.repository.BoardRepository;
import com.board.gustmd.domain.profile.data.entity.User;
import com.board.gustmd.global.board.BoardUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardUtilsImpl implements BoardUtils {
    private final BoardRepository boardRepository;

    @Override
    public List<MyPageBoardResponse> findBoardsByUserInfo(User userInfo) {
        List<Board> boardList = boardRepository.findBoardsByUser(userInfo);
        return getBoardTitle(boardList);
    }

    @Override
    public void validate(User userInfo, Board boardInfo) {
        boolean checkBoardOwner = boardRepository.existsByUserAndTitle(userInfo,boardInfo.getTitle());
        if(!checkBoardOwner) throw new NotTheOwner ();
    }

    private List<MyPageBoardResponse> getBoardTitle(List<Board>boardList){
        List<MyPageBoardResponse> list = boardList.stream().map(board->
                new MyPageBoardResponse(board.getId (),board.getTitle()))
                .collect(Collectors.toList());
        return list;
    }
}
