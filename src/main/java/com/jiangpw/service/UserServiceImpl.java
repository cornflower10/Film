package com.jiangpw.service;

import com.jiangpw.entity.BaseResult;
import com.jiangpw.entity.Email;
import com.jiangpw.entity.User;
import com.jiangpw.entity.UserVIP;
import com.jiangpw.mapper.EmailMapper;
import com.jiangpw.mapper.UserMapper;
import com.jiangpw.mapper.UserVIPMapper;
import com.jiangpw.utils.CommonUtils;
import com.jiangpw.utils.Constants;
import com.jiangpw.utils.MailUtil;
import com.jiangpw.utils.SessionUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserVIPMapper userVIPMapper;
    @Autowired
    private EmailMapper emailMapper;

    @Override
    public User findUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public BaseResult<String> login(String phone, String passWord,HttpServletRequest request) {
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
        SessionUtil.setSessionAttribute(request,Constants.SESSION_KEY,user);
        SessionUtil.removeSessionAttribute(request,Constants.SESSION_KEY_VAL);
         return new BaseResult<String>(true,"登陆成功");
    }

    @Override
    public BaseResult<String> regist(String phone, String password, String userName, String email) {


        if(StringUtils.isBlank(userName)){
            return new BaseResult<String>(false,"请填写用户名！");
        }
        if(StringUtils.isBlank(phone)){
            return new BaseResult<String>(false,"请填写手机号码！");
        }
        if(StringUtils.isBlank(password)){
            return new BaseResult<String>(false,"请填写密码！");
        }

        if(StringUtils.isBlank(email)){
            return new BaseResult<String>(false,"请填写邮箱！");
        }else {
            if(!email.matches("^\\w+@(\\w+\\.)+\\w+$")){
                return new BaseResult<String>(false,"邮箱格式错误！");
            }
        }
        User user =  userMapper.selectByPhone(Long.parseLong(phone));
        if(null!=user){
            if(user.getUsername().equals(userName.trim())){
                return new BaseResult<String>(false,"该用户名已注册！");
            }
        }
        if(null!=user){
            return new BaseResult<String>(false,"该手机号码已注册！");
        }
        if(null==user){
            try {
                user = new User();
                user.setPhone(Long.parseLong(phone));
                user.setPassword(password);
                user.setCreatetime(new Date());
                user.setUsername(userName);
                userMapper.insertSelective(user);
                UserVIP userVIP = new UserVIP();
                int userID = userMapper.selectByPhone(Long.parseLong(phone)).getId();
                userVIP.setUser_id(userID);
                userVIP.setCreate_time(new Date());
                userVIP.setVip(false);
                userVIPMapper.insert(userVIP);
                String code = CommonUtils.getUUID();
                Email email1 = new Email();
                email1.setEmail(email);
                email1.setUserid(userID);
                email1.setCode(code);
                emailMapper.insert(email1);
                new Thread(new MailUtil(email,code ,MailUtil.JIHUO)).start();

            }catch (Exception e){

                return new BaseResult<String>(true,"注册失败");
            }

            return new BaseResult<String>(true,"注册成功");
        }

        return new BaseResult<String>(false,"注册失败");
    }

    public User login(long phone) {
        return userMapper.selectByPhone(phone);
    }

    public void regist(User user) {
        userMapper.insertSelective(user);
    }
}
