package com.ssafy.study.member.payload.reqeust;

public record LoginRequestDTO(
        String email,
        String password
) {
}
