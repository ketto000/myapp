package com.codingrecipe.project01.service;

import com.codingrecipe.project01.dto.MemberDTO;
import com.codingrecipe.project01.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //repository의존성주입
public class MemberService {
    private final MemberRepository memberRepository;

    public int save(MemberDTO memberDTO){

        return memberRepository.save(memberDTO);
    }

}
