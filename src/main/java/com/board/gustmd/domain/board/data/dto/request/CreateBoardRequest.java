package com.board.gustmd.domain.board.data.dto.request;

import com.board.gustmd.domain.board.data.entity.Board;
import lombok.*;

@Getter
@RequiredArgsConstructor
public class CreateBoardRequest {
    private final String title;
    private final String userName;
    private final String description;

    public Board toEntity() {
        return Board.builder().title(title).userName(userName).description(description).build();
    }
}
