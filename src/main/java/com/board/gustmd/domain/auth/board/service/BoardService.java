package com.board.gustmd.domain.auth.board.service;

import com.board.gustmd.domain.auth.board.data.dto.request.CreateBoardRequest;
import com.board.gustmd.domain.auth.board.data.dto.response.FindAllBoardResponse;
import com.board.gustmd.domain.auth.board.data.entity.Board;
import com.board.gustmd.domain.auth.board.repository.BoardRepository;
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

    public Optional<Board> findByBoardId(Long id) {
        Optional<Board> BoardData=boardRepository.findById(id);
        return BoardData;
    }
}
