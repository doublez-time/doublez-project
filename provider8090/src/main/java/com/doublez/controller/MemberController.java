package com.doublez.controller;

import com.doublez.entity.Member;
import com.doublez.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/member")
@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/insert")
//    @HystrixCommand(fallbackMethod = "hiError")
    public String insert(Member member) {
        memberService.save(member);
        return "插入成功！";
    }

    @GetMapping("/query")
    public String query() {
        String result = "";
        for (int i = 0; i < 2; i++) {
            List<Member> memberList = memberService.selectAll();
            for(int j = 0; j<memberList.size(); j++){
                result += memberList.get(j).getName();
            }
        }
        return result;
    }
}
