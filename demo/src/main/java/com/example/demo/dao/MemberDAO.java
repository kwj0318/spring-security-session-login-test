package com.example.demo.dao;

import com.example.demo.type.MemberType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class MemberDAO {
    private String id;
    private String password;
    private String nickname;
    private MemberType memberType;
    private String phone;
    private LocalDateTime createdDate;
}
