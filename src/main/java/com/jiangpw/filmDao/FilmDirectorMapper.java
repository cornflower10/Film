package com.jiangpw.filmDao;

import com.jiangpw.entity.film.Director;
import com.jiangpw.entity.film.DirectorExample;

import java.util.List;

public interface FilmDirectorMapper {
    int deleteByPrimaryKey(String id);

    int insert(Director record);

    int insertSelective(Director record);

    List<Director> selectByExample(DirectorExample example);

    Director selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Director record);

    int updateByPrimaryKey(Director record);
}