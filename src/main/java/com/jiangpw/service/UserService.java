package com.jiangpw.service;

import com.jiangpw.entity.BaseResult;
import com.jiangpw.entity.User;

public interface UserService {
    User findUserById(int id);

    BaseResult<String> login(String phone,String passWord);

    BaseResult<String> regist(String phone, String password,String userName,String email);
}
