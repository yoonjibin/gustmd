package com.board.gustmd.domain.board.data.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MyPageBoardResponse {
    private final Long id;
    private final String title;
}
