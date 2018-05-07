package com.jiangpw.service;

import com.jiangpw.entity.User;

public interface UserService {
    User findUserById(int id);

    User login(long phone);

    void regist(User user);
}
