package com.board.gustmd.domain.auth.board.controller;

import com.board.gustmd.domain.auth.board.data.dto.request.CreateBoardRequest;
import com.board.gustmd.domain.auth.board.data.dto.response.FindAllBoardResponse;
import com.board.gustmd.domain.auth.board.data.entity.Board;
import com.board.gustmd.domain.auth.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createBoard(@RequestBody CreateBoardRequest createBoardDto) {
        boardService.createBoard (createBoardDto);
    }

    @GetMapping
    public List<FindAllBoardResponse> findAllBoard() {
        return boardService.findAllBoard ();
    }

    @GetMapping("find/{board_id}")
    public Optional<Board> findById(@PathVariable("board_id") Long id) {
        return boardService.findByBoardId(id);
    }
}
