package com.doublez.controller;

import com.doublez.entity.Member;
import com.doublez.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloWorld {

    @Autowired
    private MemberService memberService;//出错是idea自己检测不到 其实可以的

    @PostMapping("/state")
    public String saveHandler(@RequestBody Member member) {
        return "good!";
    }

    @PostMapping("/insert")
//    @HystrixCommand(fallbackMethod = "hiError")
    public String insert(Member member) {
        memberService.insert(member);
        return "插入成功！";
    }

    @GetMapping("/query")
    public String query() {
        return memberService.query();
    }

}
