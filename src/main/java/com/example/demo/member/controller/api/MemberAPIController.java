package com.example.demo.member.controller.api;

import com.example.demo.member.domain.dto.MemberDTO;
import com.example.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberAPIController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<?> joinok(MemberDTO member) {
        // 회원 가입 처리시 기타오류 발생에 대한 응답코드 설정
        ResponseEntity<?> response = ResponseEntity.internalServerError().build();

        log.info("submit된 회원 정보 : {}", member);

        try {
            // 정상 처리시 상태코드 200으로 응답
            memberService.newMember(member);
            response = ResponseEntity.ok().build();
        } catch (IllegalStateException e) {
            // 비정상 처리시 상태코드 400으로 응답 - 클라이언트 잘못
            // 중복 아이디나 중복 이메일 사용시
            response = ResponseEntity.badRequest().body(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            // 비정상 처리시 상태코드 500으로 응답 - 서버 잘못
            e.printStackTrace();
        }

        return response;
    }

}
