package com.board.gustmd.domain.auth.board.data.dto.request;

import com.board.gustmd.domain.auth.board.data.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateBoardRequest {
    private String title;
    private String userName;
    private String description;

    public Board toEntity() {
        return Board.builder().title(title).userName(userName).description(description).build();
    }
}
