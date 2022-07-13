package com.board.gustmd.domain.board.data.dto.response;

import lombok.*;

@Getter
@RequiredArgsConstructor
public class FindByBoardIdResponse {
    private final Long id;
    private final String title;
    private final String description;
    private final String userName;
}
