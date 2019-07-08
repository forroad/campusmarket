package com.zhongruan.controller;

import com.zhongruan.bean.response.Result;
import com.zhongruan.service.EnshrineService;
import com.zhongruan.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("Enshrine")
public class EnshrineController {

    @Autowired
    private EnshrineService enshrineService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    private GoodsService goodsService;


    //删除商品
    @RequestMapping("delEnshrineGoods")
    public String delEnshrineGoods(Long goodsId, Model model){
        enshrineService.delEnshrine(goodsId,Long.valueOf(request.getSession().getAttribute("userId").toString()));
        Result result = goodsService.findGoodsByUserId(Long.valueOf(request.getSession().getAttribute("userId").toString()));
        model.addAttribute("enshrineList",result.getData());
        return "mycart";
    }

}
