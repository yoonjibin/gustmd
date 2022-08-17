package com.board.gustmd.domain.profile.repository;

import com.board.gustmd.domain.profile.data.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    Boolean existsByEmail(String email);
    Boolean existsByName(String name);
    Optional<User> findUserByEmail(String email);
}
