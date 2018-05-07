package com.jiangpw.controller;

import com.jiangpw.entity.User;
import com.jiangpw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String findUser(Model model) {
        int id = 1;
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model, HttpServletRequest request, HttpServletResponse response) {
        if (null == request.getParameter("phone") || null == request.getParameter("password")) {
            return "login";
        } else {
            long phone = Long.parseLong(request.getParameter("phone"));
            String password = request.getParameter("password");

            User user = userService.login(phone);

            if (null == user) {
                return null;
            } else {
                if (password.equals(user.getPassword())) {
                    model.addAttribute("user", user);
                    return "redirect:/note/indexNote";
                } else {
                    return null;
                }
            }
        }
    }

    @RequestMapping("regist")
    public String regist(HttpServletRequest request, HttpServletResponse response) {
        if (null == request.getParameter("phone") || null == request.getParameter("username") || null == request.getParameter("password")) {
            return "regist";
        } else {
            long phone = Long.parseLong(request.getParameter("phone"));
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = new User();
            user.setUsername(username);
            user.setPhone(phone);
            user.setPassword(password);

            userService.regist(user);
            return "redirect:login";
        }
    }
}
