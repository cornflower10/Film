package com.jiangpw.controller;

import com.jiangpw.entity.BaseResult;
import com.jiangpw.entity.Reply;
import com.jiangpw.entity.User;
import com.jiangpw.service.ReplyService;
import com.jiangpw.utils.Constants;
import com.jiangpw.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @RequestMapping("/addReply")
    @ResponseBody
    public BaseResult<String> addReply(HttpServletRequest request, HttpServletResponse response) {
        int commentId = Integer.parseInt(request.getParameter("commentId"));
        int toUserId = Integer.parseInt(request.getParameter("toUserId"));
        String content = request.getParameter("content");
        User user = (User) SessionUtil.getSessionAttribute(request, Constants.SESSION_KEY);
        int fromUserId = user.getId();

        Reply reply = new Reply();
        reply.setCommentid(commentId);
        reply.setTouserid(toUserId);
        reply.setReplaycontent(content);
        reply.setFromuserid(fromUserId);

        replyService.addReply(reply);

        BaseResult<String> baseResult = new BaseResult<String>();
        baseResult.setCode("0");
        baseResult.setMsg("OK");
        baseResult.setSuccess(true);
        baseResult.setData("");

        return baseResult;
    }
}
