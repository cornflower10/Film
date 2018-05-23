package com.jiangpw.controller;

import com.jiangpw.entity.BaseResult;
import com.jiangpw.entity.Comment;
import com.jiangpw.entity.User;
import com.jiangpw.service.CommentService;
import com.jiangpw.utils.Constants;
import com.jiangpw.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/addComment")
    @ResponseBody
    public BaseResult<String> addComment(HttpServletRequest request, HttpServletResponse response) {
        int noteId = Integer.parseInt(request.getParameter("noteId"));
        String content = request.getParameter("content");
        User user = (User) SessionUtil.getSessionAttribute(request, Constants.SESSION_KEY);
        int userId = user.getId();

        Comment comment = new Comment();
        comment.setNoteid(noteId);
        comment.setUserid(userId);
        comment.setContent(content);

        commentService.add(comment);

        BaseResult<String> baseResult = new BaseResult<String>();
        baseResult.setCode("0");
        baseResult.setMsg("OK");
        baseResult.setSuccess(true);
        baseResult.setData("");

        return baseResult;
    }
}
