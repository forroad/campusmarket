package com.zhongruan.controller;

import com.zhongruan.bean.Goods;
import com.zhongruan.bean.User;
import com.zhongruan.bean.response.Result;
import com.zhongruan.dao.UserDao;
import com.zhongruan.service.AccountService;
import com.zhongruan.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("account")
public class AccountController {
    private AccountService accountService;
    private HttpSession session;
    private UserDao userDao;
    private GoodsService goodsService;

    @Autowired
    public AccountController(AccountService accountService, HttpSession session, UserDao userDao, GoodsService goodsService) {
        this.accountService = accountService;
        this.session = session;
        this.userDao = userDao;
        this.goodsService = goodsService;
    }

    @RequestMapping("login")
    public String login(String userAccount, String userPassword,String sysCode, Model model){
        String code = session.getAttribute("sysCode").toString();
        if (!sysCode.equals(code)) {
            model.addAttribute("result","验证码错误！");
            return "../login";
        }
        Result result = accountService.login(userAccount,userPassword);
        if(result.getMessage().equals("登录成功")){
            Result goodsResult = goodsService.findGoodsExc();
            return goodsService.returnPageList((List<Goods>)goodsResult.getData(),1,20,true,model);
        }
        model.addAttribute("result",result.getMessage());
        return "../login";
    }

    @RequestMapping("register")
    public String register(String userAccount,String userPassword,String userPasswordS,String userRealName,long userTelephone,String address, Model model){
       if(!userPassword.equals(userPasswordS)){
           model.addAttribute("result","两次密码不相等！");
           return "../register";
       }
        Result result = accountService.register(userAccount, userPassword, "null", userRealName, userTelephone, address);
        if(result.getMessage().equals("注册成功")){
            return "../login";
        }
        model.addAttribute("result",result.getMessage());
        return "../registerp";
    }

    @RequestMapping("modifyUser")
    public String modifyUser(String userPassword, String userRealName, long userTelephone, String address,Model model) {
        String userId = session.getAttribute("userId").toString();
        if(userId == null ||userId.isEmpty()){
            model.addAttribute("result","用户未登录");
            return "../login";
        }
        long id = Long.valueOf(userId);
        User user = userDao.findByUserId(id);
        if(user == null){
            model.addAttribute("result","服务器错误，请重新登录");
            return "../login";
        }
        if(userRealName == null || userRealName.length() <= 0){
            userRealName = user.getUserRealName();
        }
        if(userTelephone == 0){
            userTelephone = user.getUserTelephone();
        }
        if(address == null || address.length() <= 0){
            address = user.getAddress();
        }
        Result result = accountService.modifyUser(user.getUserAccount(), userPassword, user.getUserImage(), userRealName, userTelephone, address);
        model.addAttribute("result",result.getMessage());
        model.addAttribute("user",result.getData());
        return "index";
    }

}
