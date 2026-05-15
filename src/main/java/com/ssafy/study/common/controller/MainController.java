package com.ssafy.study.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage(
            @SessionAttribute(name = "memberEmail", required = false) String loginMemberEmail,
            Model model
    ) {
        if (loginMemberEmail != null) {
            model.addAttribute("memberEmail", loginMemberEmail);
        }
        return "index";
    }
}
