package com.board.gustmd.domain.board.data.entity;

import com.board.gustmd.domain.user.data.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private User user;
    public void update(String title,String description){
        this.title=title;
        this.description=description;
    }
}
