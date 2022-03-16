package web;


import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/index.jsp")
    public String tologin(){
        return "login";
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(HttpServletRequest request, User user){
        System.out.println(user.getUsername());
        boolean isValidUser=userService.Match(user.getUsername(),user.getPassword());
        if (isValidUser){
            request.getSession().setAttribute("user",user);
            return new ModelAndView("success");
        }else{
            return new ModelAndView("login","error","用户名或账户错误");
        }
    }
    @RequestMapping("/insert")
    public String InsertUser(User user, Model model) {
        userService.InsertUser(user.getUsername(), user.getPassword());
        model.addAttribute("Insert", "注册成功");
        return "success1";
    }
    @RequestMapping("/insertPage")
    public String InsertPage() {
        return "register";
    }
}