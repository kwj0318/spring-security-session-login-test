package com.example.demo.service;

import com.example.demo.dao.MemberDAO;
import com.example.demo.dto.request.MemberRequestDTO;
import com.example.demo.dto.response.MemberResponseDTO;
import com.example.demo.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void signUpAdmin(MemberRequestDTO memberRequestDTO) {
        MemberDAO memberDAO = MemberDAO.builder()
                .id(memberRequestDTO.getId())
                .password(bCryptPasswordEncoder.encode(memberRequestDTO.getPassword()))
                .nickname(memberRequestDTO.getNickname())
                .phone(memberRequestDTO.getPhone())
                .memberType(memberRequestDTO.getMemberType())
                .build();
        memberMapper.insertMember(memberDAO);
    }

    public List<MemberResponseDTO> getMemberList() {
        List<MemberDAO> members = memberMapper.getMemberListUserType();
        List<MemberResponseDTO> resultList = new ArrayList<>();

        for (MemberDAO member : members) {
            MemberResponseDTO memberInfo =  MemberResponseDTO.builder()
                    .id(member.getId())
                    .nickname(member.getNickname())
                    .phone(member.getPhone())
                    .createdDate(member.getCreatedDate())
                    .build();
            resultList.add(memberInfo);
        }
        return resultList;
    }
}
