package com.board.gustmd.domain.board.service;

import com.board.gustmd.domain.board.data.dto.request.CreateBoardRequest;
import com.board.gustmd.domain.board.data.dto.request.UpdateBoardRequest;
import com.board.gustmd.domain.board.data.dto.response.FindAllBoardResponse;
import com.board.gustmd.domain.board.data.dto.response.FindByBoardIdResponse;

public interface BoardService {
    void createBoard(CreateBoardRequest createBoardRequest);
    FindAllBoardResponse findBoardList();
    FindByBoardIdResponse findBoardById(Long boardId);
    void deleteById(Long id);
    void updateById(Long id, UpdateBoardRequest updateBoardRequest);
}
