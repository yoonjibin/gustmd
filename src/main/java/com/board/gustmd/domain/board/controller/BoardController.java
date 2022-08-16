package com.board.gustmd.domain.board.controller;

import com.board.gustmd.domain.board.data.dto.request.CreateBoardRequest;
import com.board.gustmd.domain.board.data.dto.request.UpdateBoardRequest;
import com.board.gustmd.domain.board.data.dto.response.FindAllBoardResponse;
import com.board.gustmd.domain.board.data.dto.response.FindByBoardIdResponse;
import com.board.gustmd.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createBoard(@RequestBody CreateBoardRequest createBoardDto) {
        boardService.createBoard(createBoardDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<FindAllBoardResponse> findBoardList(){
        FindAllBoardResponse findAllBoardList = boardService.findBoardList();
        return new ResponseEntity<>(findAllBoardList,HttpStatus.OK);
    }

    @GetMapping("/detail/{boardId}")
    public ResponseEntity<FindByBoardIdResponse> findBoardById(@PathVariable("boardId") Long id) {
        FindByBoardIdResponse findByBoardInfo = boardService.findBoardById(id);
        return new ResponseEntity<>(findByBoardInfo,HttpStatus.OK);
    }

    @DeleteMapping("/{boardId}")
    public ResponseEntity<Void> deleteById(@PathVariable("boardId") Long id) {
        boardService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{boardId}")
    public ResponseEntity<Void> patchById(@PathVariable("boardId")Long id,@RequestBody UpdateBoardRequest updateBoardDto){
        boardService.updateById(id,updateBoardDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
