package com.jiangpw.mapper;

import com.jiangpw.entity.Favor;
import com.jiangpw.entity.FavorExample;
import java.util.List;

public interface FavorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Favor record);

    int insertSelective(Favor record);

    List<Favor> selectByExample(FavorExample example);

    Favor selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Favor record);

    int updateByPrimaryKey(Favor record);

    Favor selectLast();
}