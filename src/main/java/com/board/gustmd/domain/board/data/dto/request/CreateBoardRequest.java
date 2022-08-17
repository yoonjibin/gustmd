package com.board.gustmd.domain.board.data.dto.request;

import com.board.gustmd.domain.board.data.entity.Board;
import com.board.gustmd.domain.profile.data.entity.User;
import lombok.*;

@Getter
@RequiredArgsConstructor
public class CreateBoardRequest {
    private final String title;
    private final String description;

    public Board toEntity(User user) {
        return Board.builder().title(title).user(user).description(description).build();
    }
}
