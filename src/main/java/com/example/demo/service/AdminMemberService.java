package com.example.demo.service;

import com.example.demo.dao.MemberDAO;
import com.example.demo.dto.response.MemberResponseDTO;
import com.example.demo.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminMemberService {

    private final MemberMapper memberMapper;

    public List<MemberResponseDTO> getMemberList() {
        List<MemberDAO> members = memberMapper.getMemberList();
        List<MemberResponseDTO> resultList = new ArrayList<>();

        for (MemberDAO member : members) {
            MemberResponseDTO memberInfo = MemberResponseDTO.builder()
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
