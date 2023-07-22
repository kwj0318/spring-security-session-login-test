package com.example.demo.dto.response;

import com.example.demo.type.MemberType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDTO {
    private String id;
    private String nickname;
    private String phone;
    private MemberType memberType;
    private LocalDateTime createdDate;
}
