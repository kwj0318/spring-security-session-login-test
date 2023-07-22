package com.example.demo.service;

import com.example.demo.dao.MemberDAO;
import com.example.demo.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {

    private final MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MemberDAO member = memberMapper.getMemberInfo(username);

        if (!username.equals(member.getId())) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails user = User
                .withUsername(member.getId())
                .password(member.getPassword())
                .authorities("ROLE_" + member.getMemberType())
                .build();
        return user;

    }
}
