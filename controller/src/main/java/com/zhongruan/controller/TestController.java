package com.zhongruan.controller;

import com.zhongruan.bean.User;
import com.zhongruan.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {
    @Autowired
    UserDao userDao;

    @GetMapping
    public String test(){
        {
            System.out.println("account:");
            String account = "18386133395";
            User user = userDao.findByUserAccount(account);
            System.out.println(user.getUserAccount() + "");
        }
        {
            System.out.println("realname:");
            String realname = "赵";
            List<User> users = userDao.findByRealname(realname);
            for (User user : users) {
                System.out.println(user.getUserAccount());
            }
        }
        {
            System.out.println("telephone:");
            long telephone = 18386133395L;
            User user = userDao.findByTelephone(telephone);
            System.out.println(user.getUserAccount());
        }
        {
            System.out.println("modifyUser");
            User user = userDao.findByUserAccount("18386133395");
            user.setUserPassword("1234567");
            user.setUserRealName("zhao");
            userDao.modifyUser(user);
        }
        {
            System.out.println("delete:");
            User user = userDao.findByUserAccount("18198189635");
            userDao.deleteUser(user.getUserId());
        }
        return "Test Successful!";
    }

    @GetMapping("testinsert")
    public int testInsert(){
        User user = new User("18386133395","123456","null","赵贻成",18386133395L,"贵州");
        return userDao.insertUser(user);
    }

}
