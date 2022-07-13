package com.board.gustmd.domain.board.data.entity;

import com.board.gustmd.domain.board.data.dto.request.UpdateBoardRequest;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor @NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String userName;
    private String description;

    public void update(UpdateBoardRequest updateBoardRequest){
        this.title=updateBoardRequest.getTitle();
        this.description= updateBoardRequest.getDescription();
    }
}
