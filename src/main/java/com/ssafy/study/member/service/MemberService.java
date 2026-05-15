package com.ssafy.study.member.service;

import com.ssafy.study.member.payload.reqeust.LoginRequestDTO;
import com.ssafy.study.member.payload.reqeust.RegistRequestDTO;

public interface MemberService {
    boolean register(RegistRequestDTO memberDTO);

    boolean login(LoginRequestDTO loginRequestDTO);
}
