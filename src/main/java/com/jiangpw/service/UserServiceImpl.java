package com.jiangpw.service;

import com.jiangpw.dao.UserDao;
import com.jiangpw.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;


    public User findUserById(int id) {
        return userDao.findUserById(id);
    }
}
