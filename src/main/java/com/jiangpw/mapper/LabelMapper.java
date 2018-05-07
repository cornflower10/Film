package com.jiangpw.mapper;

import com.jiangpw.entity.Label;
import com.jiangpw.entity.LabelExample;
import java.util.List;

public interface LabelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Label record);

    int insertSelective(Label record);

    List<Label> selectByExample(LabelExample example);

    Label selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Label record);

    int updateByPrimaryKey(Label record);
}