package com.zhongruan.service.impl;

import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import com.zhongruan.bean.User;
import com.zhongruan.bean.response.Result;
import com.zhongruan.bean.util.AccountUtils;
import com.zhongruan.dao.UserDao;
import com.zhongruan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    UserDao userDao;
    @Autowired
    HttpServletRequest request;
//
    @Override
    public Result login(String userAccount, String userPassword) {
        User user = userDao.findByUserAccount(userAccount);
        if(user == null){
            return new Result("用户名不存在",null);
        }
        if(AccountUtils.encoding(userPassword).equals(user.getUserPassword())){
            HttpSession session = request.getSession();
            session.setAttribute("userId",user.getUserId());
            return new Result("登录成功",user);
        }
        return new Result("密码错误",null);
    }

    @Override
    public Result register(String userAccount, String userPassword, String userImage, String userRealName, long userTelephone, String address) {
        if(String.valueOf(userTelephone).length() != 11){
            return new Result("手机号不规范",null);
        }
        User user = userDao.findByUserAccount(userAccount);
        if(user != null){
            return new Result("用户名已存在",null);
        }
        user = userDao.findByTelephone(userTelephone);
        if(user != null){
            return new Result("手机号已绑定",null);
        }
        user = new User(userAccount,AccountUtils.encoding(userPassword),userImage,userRealName,userTelephone,address);
        userDao.insertUser(user);
        user = userDao.findByUserAccount(userAccount);
        return new Result("注册成功",user);
    }

    @Override
    public Result modifyUser(String userAccount, String userPassword, String userImage, String userRealName, long userTelephone, String address) {
        User user = userDao.findByUserAccount(userAccount);
        if(user == null){
            return new Result("用户名不存在",null);
        }
        if(String.valueOf(userTelephone).length() != 11){
            return new Result("手机号不规范",null);
        }
        if(!AccountUtils.encoding(userPassword).equals(user.getUserPassword())){
            user.setUserPassword(AccountUtils.encoding(userPassword));
        }
        user.setUserImage(userImage);
        user.setUserRealName(userRealName);
        user.setUserTelephone(userTelephone);
        user.setAddress(address);
        userDao.modifyUser(user);
        return new Result("修改成功",user);
    }

    @Override
    public Result findByUserId(long userId) {
        User user=userDao.findByUserId(userId);
        return new Result("查询成功",user);
    }

    @Override
    public Result findByUserAccount(String userAccount) {
        User user=userDao.findByUserAccount(userAccount);
        return new Result("查询成功",user);
    }

    @Override
    public Result findByRealname(String realname) {
       List<User> user=userDao.findByRealname(realname);
        return new Result("查询成功",user);
    }

    @Override
    public Result findByTelephone(long telephone) {
        User user=userDao.findByUserId(telephone);
        return new Result("查询成功",user);
    }
}
