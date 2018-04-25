package com.jiangpw.controller;

import com.jiangpw.entity.User;
import com.jiangpw.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/findUser")
    public String findUser(Model model) {
        int id = 1;
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "index";
    }
}
