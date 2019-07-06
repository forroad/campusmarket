package com.zhongruan.controller;

import com.zhongruan.bean.User;
import com.zhongruan.bean.response.Result;
import com.zhongruan.dao.UserDao;
import com.zhongruan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.nio.cs.US_ASCII;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("account")
public class AccountController {
    private AccountService accountService;
    private HttpSession session;
    private UserDao userDao;

    @Autowired
    public AccountController(AccountService accountService,HttpSession session,UserDao userDao) {
        this.accountService = accountService;
        this.session = session;
        this.userDao =  userDao;
    }

    @RequestMapping("login")
    public String login(String userAccount, String userPassword, Model model){
        Result result = accountService.login(userAccount,userPassword);
        if(result.getMessage().equals("登录成功")){
            model.addAttribute("user",(User)result.getData());
            return "index";
        }
        model.addAttribute("result",result.getMessage());
        return "login";
    }

    @RequestMapping("register")
    public String register(String userAccount,String userPassword,String userRealName,long userTelephone,String address, Model model){
        Result result = accountService.register(userAccount, userPassword, "null", userRealName, userTelephone, address);
        if(result.getMessage().equals("注册成功")){
            return "login";
        }
        model.addAttribute("result",result.getMessage());
        return "register";
    }

    @RequestMapping("modifyUser")
    public String modifyUser(String userPassword, String userRealName, long userTelephone, String address,Model model) {
        String userId = session.getAttribute("userId").toString();
        if(userId == null ||userId.isEmpty()){
            model.addAttribute("result","用户未登录");
            return "index";
        }
        long id = Long.valueOf(userId);
        User user = userDao.findByUserId(id);
        if(user == null){
            model.addAttribute("result","服务器错误，请重新登录");
            return "login";
        }
        Result result = accountService.modifyUser(user.getUserAccount(), userPassword, user.getUserImage(), userRealName, userTelephone, address);
        model.addAttribute("result",result.getMessage());
        model.addAttribute("user",result.getData());
        return "index";
    }

}
