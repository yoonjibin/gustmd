package com.board.gustmd.domain.auth.board.controller;

import com.board.gustmd.domain.auth.board.data.dto.request.CreateBoardRequest;
import com.board.gustmd.domain.auth.board.data.entity.Board;
import com.board.gustmd.domain.auth.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {

    private final BoardService boardService;
    @PostMapping()
    public void createBoard(@RequestBody CreateBoardRequest createBoardDto){
        boardService.createBoard (createBoardDto);
    }
}
