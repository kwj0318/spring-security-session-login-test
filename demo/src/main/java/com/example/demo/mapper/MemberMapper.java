package com.example.demo.mapper;

import com.example.demo.dao.MemberDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {
    int insertMember(MemberDAO memberDAO);
    List<MemberDAO> getMemberList();
    List<MemberDAO> getMemberListUserType();
    MemberDAO getMemberInfo(String id);
}
