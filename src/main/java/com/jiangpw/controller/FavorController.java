package com.jiangpw.controller;

import com.jiangpw.entity.BaseResult;
import com.jiangpw.entity.Favor;
import com.jiangpw.service.FavorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/favor")
public class FavorController {

    @Autowired
    private FavorService favorService;

    @RequestMapping("/update")
    @ResponseBody
    public BaseResult<String> update(HttpServletRequest request, HttpServletResponse response) {
        int favorId = Integer.parseInt(request.getParameter("favorId"));

        Favor favor = favorService.selectById(favorId);
        favor.setLikecount(favor.getLikecount() + 1);

        favorService.update(favor);

        BaseResult<String> baseResult = new BaseResult<String>();
        baseResult.setCode("0");
        baseResult.setMsg("OK");
        baseResult.setData("");
        baseResult.setSuccess(true);

        return baseResult;
    }
}
