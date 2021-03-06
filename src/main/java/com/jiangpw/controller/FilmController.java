package com.jiangpw.controller;

import com.jiangpw.entity.BaseResult;
import com.jiangpw.entity.User;
import com.jiangpw.entity.film.Info;
import com.jiangpw.service.UserService;
import com.jiangpw.service.film.FilmInfoService;
import com.jiangpw.utils.HttpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private UserService userService;

    @Autowired
    private FilmInfoService filmInfoService;

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
    public BaseResult<String> doLogin(String phone, String password,String val, Model model, HttpServletRequest request, HttpServletResponse response) {
        return userService.login(phone,password,val,request);
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
    public BaseResult<String> doRegist(String phone, String password,String userName,String email,String val,HttpServletRequest request, HttpServletResponse response) {

        BaseResult<String> result = userService.regist(phone,password,userName,email,val,request);
            return result;

    }

    @RequestMapping("/query")
    @ResponseBody
    public BaseResult<String> queryByName(String key,HttpServletRequest request, HttpServletResponse response) {
        HttpUtils.searchByKey(key);
        return new BaseResult<String>();

    }


    @RequestMapping("/getData")
    @ResponseBody
    public BaseResult<List<Info>> getData(HttpServletRequest request, HttpServletResponse response) {
//        Info info = new Info();
//        info.setTitle("西部世界");
//        DBDataPram dbDataPram = new DBDataPram();
//        dbDataPram.setType("movie");
//        dbDataPram.setSort("time");
//        dbDataPram.setTag("热门");
//        dbDataPram.setPage_limit(20);
//        for (int i = 0; i <300 ; i++) {
//            dbDataPram.setPage_start(i);
//            filmInfoService.getDataFromDouBan(dbDataPram);
//        }
      List<Info> list = filmInfoService.selectByRate("8");
        return new BaseResult<List<Info>>(list);

    }
}
