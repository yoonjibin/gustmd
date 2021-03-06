package com.board.gustmd.domain.board.service.impl;

import com.board.gustmd.domain.board.data.dto.request.CreateBoardRequest;
import com.board.gustmd.domain.board.data.dto.request.UpdateBoardRequest;
import com.board.gustmd.domain.board.data.dto.response.BoardResponse;
import com.board.gustmd.domain.board.data.dto.response.FindAllBoardResponse;
import com.board.gustmd.domain.board.data.dto.response.FindByBoardIdResponse;
import com.board.gustmd.domain.board.data.entity.Board;
import com.board.gustmd.domain.board.exception.BoardNotFound;
import com.board.gustmd.domain.board.repository.BoardRepository;
import com.board.gustmd.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public void createBoard(CreateBoardRequest createBoardRequest) {
        Board boardData = createBoardRequest.toEntity();
        boardRepository.save(boardData);
    }

    @Transactional(readOnly = true)
    public FindAllBoardResponse findBoardList() {
        List<BoardResponse> boardList=findAllBoardInfo();
        return new FindAllBoardResponse(boardList);
    }

    @Transactional(readOnly = true)
    public FindByBoardIdResponse findBoardById(Long boardId) {
        Board boardInfo=boardRepository.findById(boardId).orElseThrow(BoardNotFound::new);
        return new FindByBoardIdResponse(boardInfo);
    }

    @Transactional
    public void deleteById(Long id){
        boardRepository.findById(id).orElseThrow(BoardNotFound::new);
        boardRepository.deleteById(id);
    }

    @Transactional
    public void updateById(Long id, UpdateBoardRequest updateBoardRequest){
        Board board=boardRepository.findById(id).orElseThrow(BoardNotFound::new);
        board.update(updateBoardRequest.getTitle(),updateBoardRequest.getDescription());
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
