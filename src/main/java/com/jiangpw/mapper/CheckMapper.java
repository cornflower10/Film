package com.jiangpw.mapper;

import com.jiangpw.entity.Check;
import com.jiangpw.entity.CheckExample;
import java.util.List;

public interface CheckMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Check record);

    int insertSelective(Check record);

    List<Check> selectByExample(CheckExample example);

    Check selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Check record);

    int updateByPrimaryKey(Check record);
}