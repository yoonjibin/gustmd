package com.board.gustmd.domain.user.data.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class ExractMyProfileResponse {
    private final String email;
    private final String name;
    private final List list;
}
