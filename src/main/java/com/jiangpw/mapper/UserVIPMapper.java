package com.jiangpw.mapper;

import com.jiangpw.entity.UserVIP;
import com.jiangpw.entity.UserVIPExample;
import java.util.List;

public interface UserVIPMapper {
    int insert(UserVIP record);

    int insertSelective(UserVIP record);

    List<UserVIP> selectByExampleWithBLOBs(UserVIPExample example);

    List<UserVIP> selectByExample(UserVIPExample example);

    UserVIP selectByUserId(int userID);
}