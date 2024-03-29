package com.board.gustmd.domain.board.data.dto.response;

import com.board.gustmd.domain.board.data.entity.Board;
import lombok.*;

@Getter
@RequiredArgsConstructor
public class FindByBoardIdResponse {
    private final Long id;
    private final String title;
    private final String description;
    private final String userName;

    public FindByBoardIdResponse(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.description = board.getDescription();
        this.userName = board.getUser().getName();
    }
}
