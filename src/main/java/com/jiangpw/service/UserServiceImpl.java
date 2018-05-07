package com.jiangpw.service;

import com.jiangpw.entity.User;
import com.jiangpw.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public User login(long phone) {
        return userMapper.selectByPhone(phone);
    }

    public void regist(User user) {
        userMapper.insertSelective(user);
    }
}
