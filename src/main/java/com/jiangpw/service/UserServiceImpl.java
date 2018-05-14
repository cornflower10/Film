package com.jiangpw.service;

import com.jiangpw.entity.BaseResult;
import com.jiangpw.entity.User;
import com.jiangpw.mapper.UserMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public BaseResult<String> login(String phone, String passWord) {
        if(StringUtils.isBlank(phone)){
            return new BaseResult<String>(false,"请填写手机号码！");
        }
        if(StringUtils.isBlank(passWord)){
            return new BaseResult<String>(false,"请填写密码！");
        }
       User user =  userMapper.selectByPhone(Long.parseLong(phone));
        if(user==null){
            return new BaseResult<String>(false,"该手机号码未注册！");
        }
        if(!user.getPassword().equals(passWord)){
            return new BaseResult<String>(false,"手机号或密码错误！");
        }
         return new BaseResult<String>(true,"登陆成功");
    }

    public BaseResult<String> regist(String name, String phone, String passwd) {
        if(StringUtils.isBlank(name)){
            return new BaseResult<String>(false,"请填写用户名！");
        }
        if(StringUtils.isBlank(phone)){
            return new BaseResult<String>(false,"请填写手机号码！");
        }
        if(StringUtils.isBlank(passwd)){
            return new BaseResult<String>(false,"请填写密码！");
        }
        User user =  userMapper.selectByPhone(Long.parseLong(phone));
        if(null!=user){
            if(user.getUsername().equals(name.trim())){
                return new BaseResult<String>(false,"该用户名已注册！");
            }
        }
        if(null!=user){
            return new BaseResult<String>(false,"该手机号码已注册！");
        }
        userMapper.insertSelective(user);
        return new BaseResult<String>(true,"注册成功");
    }

    public User login(long phone) {
        return userMapper.selectByPhone(phone);
    }

    public void regist(User user) {
        userMapper.insertSelective(user);
    }
}
