package com.board.gustmd.domain.board.controller;

import com.board.gustmd.domain.board.data.dto.request.CreateBoardRequest;
import com.board.gustmd.domain.board.data.dto.request.UpdateBoardRequest;
import com.board.gustmd.domain.board.data.dto.response.FindAllBoardResponse;
import com.board.gustmd.domain.board.data.entity.Board;
import com.board.gustmd.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> createBoard(@RequestBody CreateBoardRequest createBoardDto) {
        boardService.createBoard(createBoardDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<FindAllBoardResponse> findAllBoard() {
        return boardService.findAllBoard();
    }

    @GetMapping("{boardId}")
    public ResponseEntity<Board> findById(@PathVariable("boardId") Long id) {
        return boardService.findByBoardId (id);
    }

    @DeleteMapping("{boardId}")
    public void deleteById(@PathVariable("boardId") Long id) {
        boardService.deleteById(id);
    }

    @PatchMapping("{boardId}")
    public void patchById(@PathVariable("boardId")Long id,@RequestBody UpdateBoardRequest updateBoardDto){
        boardService.updateById(id,updateBoardDto);
    }
}
