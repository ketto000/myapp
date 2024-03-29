package com.codingrecipe.member.service;

import com.codingrecipe.member.dto.MemberDTO;
import com.codingrecipe.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //repository의존성주입
public class MemberService {
    private final MemberRepository memberRepository;

    public int save(MemberDTO memberDTO){
        return memberRepository.save(memberDTO);
    }

    public int memberUpdate(MemberDTO memberDTO){
        return memberRepository.memberUpdate(memberDTO);
    }

    public boolean login(MemberDTO memberDTO){
        MemberDTO loginMember = memberRepository.login(memberDTO);
        if(loginMember != null){
            return true;
        }else{
            return false;
        }
    }

    public List<MemberDTO> findAll() {
        return memberRepository.findAll();
    }

    public MemberDTO findById(Long id) {
        return memberRepository.findById(id);
    }

    public int memberDelete(Long id) { return memberRepository.memberDelete(id); }

    public MemberDTO findByUser(String memberEmail) {
        return memberRepository.findByUser(memberEmail);
    } //이메일찾기

    public String emailCheck(String  memberEmail){ //메일 확인
        MemberDTO memberDTO = memberRepository.findByUser(memberEmail);
        if(memberDTO == null){
            return "ok";
        }else{
            return "no";
        }
    }


}
