package com.jiangpw.mapper.film;

import com.jiangpw.entity.film.Director;
import com.jiangpw.entity.film.DirectorExample;
import java.util.List;

public interface DirectorMapper {
    int deleteByPrimaryKey(String id);

    int insert(Director record);

    int insertSelective(Director record);

    List<Director> selectByExample(DirectorExample example);

    Director selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Director record);

    int updateByPrimaryKey(Director record);
}