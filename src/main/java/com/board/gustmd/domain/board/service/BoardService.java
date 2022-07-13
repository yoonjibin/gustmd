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
        List<BoardResponse> boardList=findAllBoardInfo();
        return new FindAllBoardResponse(boardList);
    }

    public FindByBoardIdResponse findByBoardId(Long boardId) {
        Board boardInfo=boardRepository.findById(boardId).orElseThrow(BoardNotFound::new);
        Long id =boardInfo.getId();
        String title=boardInfo.getTitle();
        String userName=boardInfo.getUserName();
        String description=boardInfo.getDescription();

        return new FindByBoardIdResponse(id,title,userName,description);
    }

    public void deleteById(Long id){
        boardRepository.findById(id).orElseThrow(BoardNotFound::new);
        boardRepository.deleteById(id);
    }

    public void updateById(Long id, UpdateBoardRequest updateBoardRequest){
        Board board=boardRepository.findById(id).orElseThrow(BoardNotFound::new);

        board.update(updateBoardRequest);
    }
    private List<BoardResponse> findAllBoardInfo(){
        List<BoardResponse> List = new ArrayList<>();
        boardRepository.findAll().forEach(board -> {
            Long id = board.getId();
            String title= board.getTitle();
            String userName=board.getUserName();
            List.add(new BoardResponse(id,title,userName));
        });
        return List;
    }
}
