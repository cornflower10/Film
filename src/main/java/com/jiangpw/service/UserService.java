package com.jiangpw.service;

import com.jiangpw.entity.BaseResult;
import com.jiangpw.entity.User;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    User findUserById(int id);

    BaseResult<String> login(String phone,String passWord,String val,HttpServletRequest request);

    BaseResult<String> regist(String phone, String password,String userName,String email,String val,HttpServletRequest request);
}
