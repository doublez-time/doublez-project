package com.doublez.service;

import com.doublez.entity.Member;

import java.util.List;

public interface MemberService {

    int insert(Member member);

    int save(Member member);

    List<Member> selectAll();

    String getToken(String appId);
}
