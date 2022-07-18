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
    private String title;
    private String userName;
    private String description;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private User user;
    public void update(String title,String description){
        this.title=title;
        this.description=description;
    }
}
