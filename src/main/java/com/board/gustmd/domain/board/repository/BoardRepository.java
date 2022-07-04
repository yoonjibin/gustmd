package com.board.gustmd.domain.board.repository;

import com.board.gustmd.domain.board.data.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {
}
