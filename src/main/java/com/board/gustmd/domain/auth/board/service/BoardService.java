package com.board.gustmd.domain.auth.board.service;

import com.board.gustmd.domain.auth.board.data.dto.request.CreateBoardRequest;
import com.board.gustmd.domain.auth.board.data.dto.response.findAllBoardResponse;
import com.board.gustmd.domain.auth.board.data.entity.Board;
import com.board.gustmd.domain.auth.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public void createBoard(CreateBoardRequest createBoardRequest) {
        Board boardData = createBoardRequest.toEntity();
        boardRepository.save (boardData);
    }

    public findAllBoardResponse findAllBoard(){
        findAllBoardResponse BoardData=new findAllBoardResponse();

        return BoardData;
    }
}
