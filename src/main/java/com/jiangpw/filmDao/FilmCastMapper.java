package com.jiangpw.filmDao;

import com.jiangpw.entity.film.Cast;
import com.jiangpw.entity.film.CastExample;
import java.util.List;

public interface FilmCastMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cast record);

    int insertSelective(Cast record);

    List<Cast> selectByExample(CastExample example);

    Cast selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cast record);

    int updateByPrimaryKey(Cast record);
}