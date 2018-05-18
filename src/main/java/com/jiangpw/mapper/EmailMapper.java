package com.jiangpw.mapper;

import com.jiangpw.entity.Email;
import com.jiangpw.entity.EmailExample;
import java.util.List;

public interface EmailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Email record);

    int insertSelective(Email record);

    List<Email> selectByExample(EmailExample example);

    Email selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Email record);

    int updateByPrimaryKey(Email record);
}