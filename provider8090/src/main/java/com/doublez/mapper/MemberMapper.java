package com.doublez.mapper;

import com.doublez.entity.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Insert("insert into member(name) values(#{name})")
    int insert(Member member);

    @Insert("insert into member(name) values(#{name})")
    int save(Member member);

    @Select("select * from member")
    @Results(id = "member",value= {
            @Result(property = "id", column = "id", javaType = Integer.class),
            @Result(property = "name", column = "name", javaType = String.class)
    })
    List<Member> selectByExample();

}
