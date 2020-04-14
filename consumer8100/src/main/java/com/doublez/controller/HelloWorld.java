package com.doublez.controller;

import com.doublez.entity.Member;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorld {

    @PostMapping("/state")
    public String saveHandler(@RequestBody Member member) {
        return "good!";
    }

}
