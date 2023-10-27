package com.codingrecipe.member.controller;


import com.codingrecipe.member.dto.MemberDTO;
import com.codingrecipe.member.repository.MemberRepository;
import com.codingrecipe.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/member"  )
@RequiredArgsConstructor  //repository 의존성 주입
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @GetMapping("/save")
    public String saveForm(){
        return "save";
    }
    @PostMapping("/save")
    public String save(
            @ModelAttribute MemberDTO memberDTO,
            @RequestParam("memberEmail") String name, Model model ){
        System.out.println(name);
        model.addAttribute("member", memberDTO);//model리턴
        memberDTO.toString();

       int saveResult = memberService.save(memberDTO);
        if(saveResult > 0 ){
            return "login";
        }else{
            return "redirect:/member/save";
        }
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session, Model model){
        boolean loginResult = memberService.login(memberDTO);


        if(loginResult){
            session.setAttribute("loginEmail", memberDTO.getMemberEmail());
            MemberDTO member = new MemberDTO();
            member=memberService.findByUser(memberDTO.getMemberEmail());
            model.addAttribute("member",member);
            return "main";
        }else{
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

    @GetMapping("/")
    public String findAll(Model model){
        List <MemberDTO> memberList = new ArrayList<>();
        memberList=memberService.findAll();
        model.addAttribute("memberList",memberList);
        return "list";
    }

    @GetMapping
    public String findById(@RequestParam("id") Long id, Model model){
        MemberDTO member = new MemberDTO();
        member=memberService.findById(id);
        model.addAttribute("member",member);
        return "detail";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam("id") Long id, Model model){
        MemberDTO member = new MemberDTO();
        member=memberService.findById(id);
        model.addAttribute("member",member);
        return "updateForm";
    }

    @PostMapping("/memberUpdate")
    public String memberUpdate(@ModelAttribute(value= "member") MemberDTO memberDTO, Model model){
        memberService.memberUpdate(memberDTO);
        model.addAttribute("member",memberDTO);
        return "detail";
    }

    @GetMapping("/memberDelete")
    public String memberDelete(@RequestParam("id") Long id, Model model){
        memberService.memberDelete(id);

        return "redirect:/member/";
    }

}
