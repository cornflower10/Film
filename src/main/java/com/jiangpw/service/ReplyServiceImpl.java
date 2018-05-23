package com.jiangpw.service;

import com.jiangpw.entity.Reply;
import com.jiangpw.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("replyService")
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public void addReply(Reply reply) {
        replyMapper.insertSelective(reply);
    }
}
