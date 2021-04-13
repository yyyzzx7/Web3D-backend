package com.example.springboottest1.controller;


import com.example.springboottest1.api.CommonResult;
import com.example.springboottest1.entity.User;
import com.example.springboottest1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    HttpSession session;



    @RequestMapping(value = "/login",method = POST, produces = "application/json;charset=UTF-8")
    public CommonResult<Object> userLogin(
            @RequestBody Map<String, String> map,
            HttpServletRequest request,
            HttpServletResponse response)
    {

        String username = map.get("username");
        String password = map.get("password");

        User user = userService.userLogin(username, password);// 根据帐号密码查询用户

        if(user != null){   // 如果登录成功
            session = request.getSession(); // 存储session
            session.setAttribute("current_user_id", user.getUser_id());// 存储当前登录用户的ID
            return CommonResult.success("welcome " + username);
        }else {
            return CommonResult.failed("用户名或密码错误");
        }
    }




    @RequestMapping(value = "/achievement", method = GET, produces = "application/json;charset=UTF-8")
    public Map<String,Object> userAchievement(){
        String user_id = (String) session.getAttribute("current_user_id");// 获取当前session中的用户
        return userService.userAchievement(user_id);
    }

}
