package com.rubypaper.controller;

import com.rubypaper.domain.Member;
import com.rubypaper.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

// 세션에 member를 상태정보로 등록
@SessionAttributes("member")
@Controller
public class LoginController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/login")
    public void loginView() {
    }

    @PostMapping("/login")
    public String login(Member member, Model model) {
        Member findMember = memberService.getMember(member);

        if (findMember != null && findMember.getPassword().equals(member.getPassword())) {
            model.addAttribute("member", findMember);
            return "forward:getBoardList";
        } else {
            return "redirect:login";
        }
    }

    @GetMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete(); //세션 강제 종료
        return "redirect:index.html";
    }
}
