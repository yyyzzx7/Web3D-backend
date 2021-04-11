package com.example.springboottest1.mapper;

import com.example.springboottest1.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Mapper
@Component
public interface UserMapper {
    //用户登录
    User userLogin(@Param("username") String login_name, @Param("password") String login_pwd);


    // 用户成就
    List<Map<String,Object>> userAchievement(@Param("user_id") String user_id);
}