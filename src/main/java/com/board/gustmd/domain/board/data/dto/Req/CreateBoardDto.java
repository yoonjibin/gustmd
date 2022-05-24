package com.board.gustmd.domain.board.data.dto.Req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBoardDto {
    private String title;
    private String userName;
    private String description;
}
