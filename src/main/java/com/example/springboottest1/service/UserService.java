package com.example.springboottest1.service;


import com.example.springboottest1.entity.User;
import com.example.springboottest1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    // 用户登录
    public User userLogin(String login_name, String login_pwd){
        return userMapper.userLogin(login_name, login_pwd);
    }


    // 用户成就
    public Map<String,Object> userAchievement(String user_id){
        Map<String,Object> achievementMap = new HashMap<>();
        achievementMap.put("uuid", user_id);

        List<Map<String, Object>> searchResult = userMapper.userAchievement(user_id);
        List<Map<String, Object>> learning = new LinkedList<>();        // learning成就数组
        List<Map<String, Object>> concentration = new LinkedList<>();   // concentration成就数组
        List<Map<String, Object>> creativity = new LinkedList<>();      // creativity成就数组
        // 遍历全部成就，按照成就的类型进行分类，组成list
        for (Map<String, Object> currentAchievement : searchResult) {
            String currentType = (String) currentAchievement.get("type");
            // 前端不显示type
            currentAchievement.remove("type");
            // 将finished字段换成布尔值
            if((Integer)currentAchievement.get("finished") == 0){
                currentAchievement.put("finished", false);
            }else{
                currentAchievement.put("finished", true);
            }

            switch (currentType) {
                case "learning":
                    learning.add(currentAchievement);
                    break;
                case "concentration":
                    concentration.add(currentAchievement);
                    break;
                case "creativity":
                    creativity.add(currentAchievement);
                    break;
            }
        }
        achievementMap.put("learning", learning);
        achievementMap.put("concentration", concentration);
        achievementMap.put("creativity", creativity);

        return achievementMap;
    }
}
