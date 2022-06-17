package com.board.gustmd.domain.auth.board.data.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder()
@NoArgsConstructor()
@AllArgsConstructor()
@Data()
public class UpdateBoardRequest{
    private String title;

    private String description;
}
