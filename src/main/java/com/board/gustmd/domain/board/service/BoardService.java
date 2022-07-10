package com.board.gustmd.domain.board.service;

import com.board.gustmd.domain.board.data.dto.request.CreateBoardRequest;
import com.board.gustmd.domain.board.data.dto.request.UpdateBoardRequest;
import com.board.gustmd.domain.board.data.dto.response.FindAllBoardResponse;
import com.board.gustmd.domain.board.data.entity.Board;
import com.board.gustmd.domain.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public void createBoard(CreateBoardRequest createBoardRequest) {
        Board boardData = createBoardRequest.toEntity();
        boardRepository.save(boardData);
    }

    public List<FindAllBoardResponse> findAllBoard() {
        List<FindAllBoardResponse> boardList = new ArrayList<>();
        boardRepository.findAll().forEach (board -> {
            boardList.add (FindAllBoardResponse.builder()
                     .id (board.getId())
                     .title (board.getTitle())
                     .userName(board.getUserName())
                     .build());
        });
        return boardList;
    }

    public Board findByBoardId(Long id) {
        return boardRepository.findById(id).orElseThrow(()->);
    }

    public void deleteById(Long id){
        boardRepository.deleteById(id);
    }

    public void updateById(Long id, UpdateBoardRequest updateBoardRequest){
        Board board=boardRepository.findById(id).orElseThrow();

        board.update(updateBoardRequest);
    }
}
