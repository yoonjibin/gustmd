package com.board.gustmd.domain.auth.user.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long Member_id;

    @Column
    private String email;

    @Column
    private String password;
}
