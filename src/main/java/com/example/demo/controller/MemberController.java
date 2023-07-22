package com.example.demo.controller;

import com.example.demo.dto.request.MemberRequestDTO;
import com.example.demo.dto.response.MemberResponseDTO;
import com.example.demo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public void signUpAdmin(@RequestBody MemberRequestDTO memberRequestDTO){
        memberService.signUpAdmin(memberRequestDTO);
    }

    @GetMapping("/members")
    public ResponseEntity<Object> getMemberList(){
        return ResponseEntity.status(HttpStatus.OK).body(memberService.getMemberList());
    }

}
