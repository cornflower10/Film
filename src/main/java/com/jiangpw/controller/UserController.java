package com.jiangpw.controller;

import com.jiangpw.entity.BaseResult;
import com.jiangpw.entity.User;
import com.jiangpw.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
//        if (null == request.getParameter("phone") || null == request.getParameter("password")) {
//            return "login";
//        } else {
//            long phone = Long.parseLong(request.getParameter("phone"));
//            String password = request.getParameter("password");
//
//            User user = userService.login(phone);
//
//            if (null == user) {
//                return null;
//            } else {
//                if (password.equals(user.getPassword())) {
//                    model.addAttribute("user", user);
//                    return "redirect:/note/indexNote";
//                } else {
//                    return null;
//                }
//            }
//        }
        return "login";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public BaseResult<String> doLogin(String phone, String password, Model model, HttpServletRequest request, HttpServletResponse response) {
        return userService.login(phone,password);
    }

    @RequestMapping("/regist")
    public String regist(HttpServletRequest request, HttpServletResponse response) {
            return "regist";

    }

    @RequestMapping("/check")
    public String check(HttpServletRequest request, HttpServletResponse response) {
        return "check";

    }


    @RequestMapping("/doRegist")
    @ResponseBody
    public BaseResult<String> doRegist(String phone, String password,String userName,HttpServletRequest request, HttpServletResponse response) {

        BaseResult<String> result = userService.regist(phone,password,userName);
            return result;

    }
}
