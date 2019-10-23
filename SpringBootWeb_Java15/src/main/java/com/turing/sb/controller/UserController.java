package com.turing.sb.controller;

import com.turing.sb.entity.User;
import com.turing.sb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

//    //访问主页的控制器
//    @GetMapping("/index")
//    public String index(){
//        return "index";
//    }
//
//    //访问登录的控制器
//    @GetMapping("/")
//    public String login(){
//        return "login";
//    }

    //登录
    @PostMapping("/login")
    public String login(User user, HttpSession session){
        user = userService.login(user);
        if(user == null){
            //重定向：登录页面
            return "redirect:/";
        }else{
            //重定向：主页
            //保存session
            session.setAttribute("user",user);
            return "redirect:/index";
        }
    }
}
