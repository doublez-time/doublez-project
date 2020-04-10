package com.doublez;

import com.doublez.entity.Member;
import com.doublez.service.MemberService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableEurekaClient // 服务提供
@MapperScan(value = "com.doublez.mapper")
@RestController
@SpringBootApplication
public class Provider8090Application {
    public static void main(String[] args) {
        SpringApplication.run(Provider8090Application.class, args);
    }

    @Autowired
    private MemberService memberService;

    @RequestMapping("/insert")
//    @HystrixCommand(fallbackMethod = "hiError")
    public String insert(Member member) {
        memberService.save(member);
        return "插入成功！";
    }

    @RequestMapping("/query")
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

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
