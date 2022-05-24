package com.board.gustmd.domain.board.controller;

import com.board.gustmd.domain.board.data.dto.Req.CreateBoardDto;
import com.board.gustmd.domain.board.data.entity.Board;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("board")
public class BoardController {

    @PostMapping("")
    public void createBoard(@RequestBody CreateBoardDto createBoardDto){
        return;
    }
}
