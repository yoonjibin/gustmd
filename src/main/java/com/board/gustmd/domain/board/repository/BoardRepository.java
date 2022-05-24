package com.board.gustmd.domain.board.repository;

import com.board.gustmd.domain.board.data.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Member;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board,Long> {
}
