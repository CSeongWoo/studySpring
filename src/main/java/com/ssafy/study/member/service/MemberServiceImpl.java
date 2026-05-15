package com.ssafy.study.member.service;

import com.ssafy.study.member.entity.Member;
import com.ssafy.study.member.payload.reqeust.LoginRequestDTO;
import com.ssafy.study.member.payload.reqeust.RegistRequestDTO;
import com.ssafy.study.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;

    @Override
    public boolean register(RegistRequestDTO memberDTO) {
        Member member = new Member().builder()
                .email(memberDTO.email())
                .password(memberDTO.password())
                .name(memberDTO.name())
                .build();

        if (memberRepository.existsByEmail(member.getEmail())) {
            return false;
        }

        memberRepository.save(member);
        return true;
    }

    @Override
    public boolean login(LoginRequestDTO loginRequestDTO) {
        Member member = memberRepository.findMemberByEmail((loginRequestDTO.email()));

        if (!member.getPassword().equals(loginRequestDTO.password())) {
            return false;
        }
        return true;
    }
}
