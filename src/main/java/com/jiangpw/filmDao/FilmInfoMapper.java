package com.jiangpw.filmDao;

import com.jiangpw.entity.film.Info;
import com.jiangpw.entity.film.InfoExample;

import java.util.List;

public interface FilmInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Info record);

    int insertList(List<Info> infos);

    int insertSelective(Info record);

    List<Info> selectByExample(InfoExample example);

    Info selectByPrimaryKey(Integer id);

    List<Info> selectByRate(String rate);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);
}