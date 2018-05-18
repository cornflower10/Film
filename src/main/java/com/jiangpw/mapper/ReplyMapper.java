package com.jiangpw.mapper;

import com.jiangpw.entity.Reply;
import com.jiangpw.entity.ReplyExample;
import java.util.List;

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Reply record);

    int insertSelective(Reply record);

    List<Reply> selectByExample(ReplyExample example);

    Reply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKey(Reply record);

    List<Reply> getReplyByCommentId(int commentId);
}