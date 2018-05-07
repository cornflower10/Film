package com.jiangpw.mapper;

import com.jiangpw.entity.Like;
import com.jiangpw.entity.LikeExample;
import java.util.List;

public interface LikeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Like record);

    int insertSelective(Like record);

    List<Like> selectByExample(LikeExample example);

    Like selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Like record);

    int updateByPrimaryKey(Like record);
}