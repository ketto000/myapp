package com.codingrecipe.member.repository;

import com.codingrecipe.member.dto.MemberDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository
{
    private final SqlSessionTemplate sql; //mybatis class

    public int save(MemberDTO memberDTO) {
        System.out.println("memberDTO = " + memberDTO);
        return sql.insert("Member.save", memberDTO); //Member<-namespace , save<-id
    }


    public MemberDTO login(MemberDTO memberDTO) {
        return sql.selectOne("Member.login", memberDTO); //한개의 값
    }

    public List <MemberDTO> findAll() {
        return sql.selectList("Member.findAll"); //한개의 값
    }

    public MemberDTO findById(Long id){
        return sql.selectOne("Member.findById", id);
    }

}
