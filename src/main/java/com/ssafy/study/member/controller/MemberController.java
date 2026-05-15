package com.ssafy.study.member.controller;

import com.ssafy.study.member.payload.reqeust.LoginRequestDTO;
import com.ssafy.study.member.payload.reqeust.RegistRequestDTO;
import com.ssafy.study.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @PostMapping("/login")
    public String loginProcess(@ModelAttribute LoginRequestDTO request, HttpServletRequest httpRequest) {
        boolean success = memberService.login(request);
        if (success) {
            HttpSession session = httpRequest.getSession();

            session.setAttribute("memberEmail", request.email());
            return "redirect:/";
        } else {
            return "member/login?error=true";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

    @PostMapping("/register")
    public String registerProcess(@ModelAttribute RegistRequestDTO request) {
        boolean success = memberService.register(request);
        if (success) {
            return "redirect:/member/login";
        } else {
            return "redirect:/member/login?error=true";
        }
    }

}
