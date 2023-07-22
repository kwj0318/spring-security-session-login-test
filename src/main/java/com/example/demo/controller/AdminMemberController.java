package com.example.demo.controller;

import com.example.demo.dto.request.MemberRequestDTO;
import com.example.demo.service.AdminMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminMemberController {

    private final AdminMemberService adminMemberService;

    @GetMapping("/members")
    public ResponseEntity<Object> getMemberList() {
        return ResponseEntity.status(HttpStatus.OK).body(adminMemberService.getMemberList());
    }
}
