package com.board.gustmd.domain.board.data.dto.response;

import lombok.*;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class FindAllBoardResponse {
    private final List<BoardResponse> list;
}
