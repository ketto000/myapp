package com.codingrecipe.member.controller;


import com.codingrecipe.member.dto.MemberDTO;
import com.codingrecipe.member.repository.MemberRepository;
import com.codingrecipe.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
            return "save";
        }

    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

    @GetMapping("/")
    public String memberList(){

        return "memberList";
    }


}
