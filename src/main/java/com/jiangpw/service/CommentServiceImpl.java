package com.jiangpw.service;

import com.jiangpw.entity.Comment;
import com.jiangpw.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void add(Comment comment) {
        commentMapper.insertSelective(comment);
    }
}
