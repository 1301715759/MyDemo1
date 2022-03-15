package com.web;


import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.service.UserService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/tologin")
    public String tologin(){
        return "login";
    }

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, User user){
        System.out.println(user.getUsername());
        boolean isValidUser=userService.hasMatch(user.getUsername(),user.getPassword());
        if (isValidUser){
            request.getSession().setAttribute("user",user);
            return new ModelAndView("success");
        }else{
            return new ModelAndView("login","error","用户名或账户错误");
        }
    }
}