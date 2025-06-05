package com.example.demo.member.service;

import com.example.demo.member.domain.dto.LoginDTO;
import com.example.demo.member.domain.dto.MemberDTO;
import com.example.demo.member.domain.Member;

public interface MemberService {

    boolean newMember(MemberDTO member);
    Member loginMember(LoginDTO member);

}
