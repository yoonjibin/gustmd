package com.board.gustmd.domain.board.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBoardRequest {
    private String title;
    private String userName;
    private String description;
}
