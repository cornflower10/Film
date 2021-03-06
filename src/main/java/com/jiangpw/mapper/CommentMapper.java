package com.jiangpw.mapper;

import com.jiangpw.entity.Comment;
import com.jiangpw.entity.CommentExample;
import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> selectAllCommentByNoteId(int noteId);
}