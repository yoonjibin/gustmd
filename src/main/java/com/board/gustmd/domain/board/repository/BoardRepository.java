package com.board.gustmd.domain.board.repository;

import com.board.gustmd.domain.board.data.entity.Board;
import com.board.gustmd.domain.user.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {
    List<Board> findBoardsByUser(User userInfo);
}

