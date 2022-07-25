package com.board.gustmd.domain.user.repository;

import com.board.gustmd.domain.user.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
