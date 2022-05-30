package com.board.gustmd.domain.auth.board.controller;

import com.board.gustmd.domain.auth.board.data.dto.request.CreateBoardRequest;
import com.board.gustmd.domain.auth.board.data.dto.response.FindAllBoardResponse;
import com.board.gustmd.domain.auth.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBoard(@RequestBody CreateBoardRequest createBoardDto){
        boardService.createBoard (createBoardDto);
    }

    @GetMapping
    public List<FindAllBoardResponse> findAllBoard(){
        return boardService.findAllBoard();
    }
}
