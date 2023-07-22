package com.example.demo.dto.request;

import com.example.demo.type.MemberType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDTO {
    private String id;
    private String password;
    private String nickname;
    @JsonProperty(value = "member_type")
    private MemberType memberType;
    private String phone;
}
