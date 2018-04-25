package com.jiangpw.dao;

import com.jiangpw.entity.User;

public interface UserDao {
    User findUserById(int id);
}
