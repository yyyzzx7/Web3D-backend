package com.example.springboottest1.controller;


import com.example.springboottest1.api.CommonResult;
import com.example.springboottest1.entity.User;
import com.example.springboottest1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = POST, produces = "application/json;charset=UTF-8")
    public CommonResult<Object> userLogin(@RequestBody Map<String, String> map){
        String id = map.get("username");
        String pw = map.get("password");
        User user = userService.userLogin(id, pw);
        if(user != null){   // 如果登录成功
            return CommonResult.success("welcome " + id);
        }else {
            return CommonResult.failed("??");
        }
    }


    /*@RequestMapping(value = "/achievement", method = GET, produces = "application/json;charset=UTF-8")
    public Map<String,Object> userAchievement(Authentication authentication){
        String user_id = authentication.getUsername();
        System.out.println(user_id);
        return userService.userAchievement(user_id);
    }*/
    @RequestMapping(value = "/achievement/{user_id}", method = GET, produces = "application/json;charset=UTF-8")
    public Map<String,Object> userAchievement(@PathVariable("user_id") String user_id){
        return userService.userAchievement(user_id);
    }

}
