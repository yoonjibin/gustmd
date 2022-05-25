package com.board.gustmd.domain.auth.board.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String userName;

    @Column
    private String description;
}
