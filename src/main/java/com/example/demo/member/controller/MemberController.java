package com.example.demo.member.controller;

import com.example.demo.member.domain.Member;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

    @Value("${recaptcha_sitekey}")
    private String sitekey;


    @GetMapping("/join")
    public String join(Model model)
    {

        model.addAttribute("sitekey", sitekey);

        return "views/member/join";
    }

    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("sitekey", sitekey);

        return "views/member/login";
    }

    @GetMapping("/myinfo")
    public String myinfo(Model model, HttpSession session) {
        String returnPage = "redirect:/member/login";
//        Member user = new Member(0,"abc123","abc123","abc123",
//                "abc123@abc123.co.kr", LocalDateTime.now());
//        model.addAttribute("loginUser", user);

        if (session.getAttribute("loginUser") != null) {
            model.addAttribute("loginUser", session.getAttribute("loginUser"));
            returnPage = "views/member/myinfo";
        }

        return returnPage;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();

        return "redirect:/";
    }
}
