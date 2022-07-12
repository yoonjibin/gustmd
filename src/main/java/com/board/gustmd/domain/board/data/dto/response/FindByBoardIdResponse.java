package com.board.gustmd.domain.board.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindByBoardIdResponse {
    private Long id;
    private String title;
    private String description;
    private String userName;
}
