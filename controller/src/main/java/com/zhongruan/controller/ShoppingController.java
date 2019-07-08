package com.zhongruan.controller;

import com.zhongruan.bean.Goods;
import com.zhongruan.bean.response.Result;
import com.zhongruan.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("shop")
public class ShoppingController {
    private Logger log = LoggerFactory.getLogger(ShoppingController.class);
    @Autowired
    private GoodsService goodsService;

    //模糊查询
    @RequestMapping("shopping")
    public String goods(String goodsName,Model model){
        Result result = goodsService.findByGoodsNameLike(goodsName);
        return goodsService.returnPageList((List<Goods>) result.getData(),1,20,true,model);
    }

}
