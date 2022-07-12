package com.board.gustmd.domain.board.service;

import com.board.gustmd.domain.board.data.dto.request.CreateBoardRequest;
import com.board.gustmd.domain.board.data.dto.request.UpdateBoardRequest;
import com.board.gustmd.domain.board.data.dto.response.BoardResponse;
import com.board.gustmd.domain.board.data.dto.response.FindAllBoardResponse;
import com.board.gustmd.domain.board.data.dto.response.FindByBoardIdResponse;
import com.board.gustmd.domain.board.data.entity.Board;
import com.board.gustmd.domain.board.exception.BoardNotFound;
import com.board.gustmd.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public void createBoard(CreateBoardRequest createBoardRequest) {
        Board boardData = createBoardRequest.toEntity();
        boardRepository.save(boardData);
    }

    public FindAllBoardResponse findAllBoard() {
        List<BoardResponse> boardList = new ArrayList<>();
        boardRepository.findAll().forEach(board -> {
            boardList.add(BoardResponse.builder()
                     .id(board.getId())
                     .title(board.getTitle())
                     .userName(board.getUserName())
                     .build());
        });
        return FindAllBoardResponse.builder()
                .list(boardList)
                .build();
    }

    public FindByBoardIdResponse findByBoardId(Long id) {
        Board boardInfo=boardRepository.findById(id).orElseThrow(BoardNotFound::new);

        return FindByBoardIdResponse.builder()
                                    .id(boardInfo.getId())
                                    .title(boardInfo.getTitle())
                                    .description(boardInfo.getDescription())
                                    .userName(boardInfo.getUserName())
                                    .build();
    }

    public void deleteById(Long id){
        boardRepository.findById(id).orElseThrow(BoardNotFound::new);
        boardRepository.deleteById(id);
    }

    public void updateById(Long id, UpdateBoardRequest updateBoardRequest){
        Board board=boardRepository.findById(id).orElseThrow(BoardNotFound::new);

        board.update(updateBoardRequest);
    }
}
