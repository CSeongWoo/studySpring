package com.ssafy.study.member.payload.reqeust;

public record RegistRequestDTO(
        String email,
        String password,
        String name
) {
}
