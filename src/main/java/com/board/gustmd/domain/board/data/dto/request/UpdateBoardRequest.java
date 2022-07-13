package com.board.gustmd.domain.board.data.dto.request;

import lombok.*;

@Getter
@RequiredArgsConstructor
public class UpdateBoardRequest{
    private final String title;

    private final String description;
}
