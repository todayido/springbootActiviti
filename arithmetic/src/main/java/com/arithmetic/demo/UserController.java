package com.arithmetic.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UserService userService;

    @RequestMapping("/api/login")
    public String Login(User user) {

        HttpSession session = request.getSession();

        //存入Session
        //session.setAttribute("user", user);
        //单位为秒，设置为-1时不再失效
        //session.setMaxInactiveInterval(60 * 60 * 24 * 30);
        //注销登陆
        //request.getSession().removeAttribute("user");

        List<User> users =  userService.AllUser();
        for (int i = 0; i <users.size() ; i++) {
            System.out.println(users.get(i));
        }
        return userService.AllUser().toString();
    }
}
