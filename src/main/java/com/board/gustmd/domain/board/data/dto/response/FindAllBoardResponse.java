package com.board.gustmd.domain.board.data.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FindAllBoardResponse {
    private Long id;
    private String title;
    private String userName;
}
