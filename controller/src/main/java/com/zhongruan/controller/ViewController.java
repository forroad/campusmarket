package com.zhongruan.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zhongruan.bean.Goods;
import com.zhongruan.bean.Purchase;
import com.zhongruan.bean.User;
import com.zhongruan.bean.response.Result;
import com.zhongruan.dao.UserDao;
import com.zhongruan.service.GoodsService;
import com.zhongruan.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("view")
public class ViewController {
    private GoodsService goodsService;
    private UserDao userDao;
    private PurchaseService purchaseService;
    private HttpServletRequest request;

    @Autowired
    public ViewController(GoodsService goodsService, UserDao userDao, PurchaseService purchaseService, HttpServletRequest request) {
        this.goodsService = goodsService;
        this.userDao = userDao;
        this.purchaseService = purchaseService;
        this.request = request;
    }

    @RequestMapping("main")
    public String main(){
        return "main";
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("register")
    public String register(){
        return "register";
    }

    @RequestMapping("index")
    public String index(Model model){
        String userId = request.getSession().getAttribute("userId").toString();
        long id = Long.valueOf(userId);
        User user = userDao.findByUserId(id);
        model.addAttribute("user",user);
        return "index";
    }

    @RequestMapping("shopping")
    public String shopping(){
        return "shopping";
    }

    @RequestMapping("mycart")
    public String mycart(){
        return "mycart";
    }

    @RequestMapping("addshopping")
    public String addshopping(){
        return "addshopping";
    }

    @RequestMapping("myshopping")
    public String myshopping(Model model){
        Result result = goodsService.findByGoodsPopularityAsc();
        model.addAttribute("goodsList",result.getData());
        return "myshopping";
    }

    @RequestMapping("myorder")
    public String myorder(Model model){
        Result result = goodsService.findByIsBuyAndUserId(Long.valueOf(request.getSession().getAttribute("userId").toString()));
        model.addAttribute("goodsList",result.getData());
        return "myorder";
    }
}
