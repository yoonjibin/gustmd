package com.board.gustmd.domain.board.controller;

import com.board.gustmd.domain.board.data.dto.request.CreateBoardRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("board")
public class BoardController {

    @PostMapping("")
    public void createBoard(@RequestBody CreateBoardRequest createBoardDto){
        return;
    }
}
