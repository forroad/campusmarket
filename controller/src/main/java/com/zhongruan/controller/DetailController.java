package com.zhongruan.controller;

import com.zhongruan.bean.Goods;
import com.zhongruan.bean.response.Result;
import com.zhongruan.service.EnshrineService;
import com.zhongruan.service.GoodsService;
import com.zhongruan.service.PurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("detail")
public class DetailController {
    private Logger log = LoggerFactory.getLogger(ShoppingController.class);
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private EnshrineService enshrineService;
    @Autowired
    private PurchaseService purchaseService;
    @Autowired
    private HttpServletRequest request;

    //增加收藏
    @RequestMapping("enshire")
    public String addenshire(Long goodsId, Model model){
        Result result=enshrineService.addEnshrine(Long.valueOf(request.getSession().getAttribute("userId").toString()),goodsId);
        if(result.getMessage().equals("增加收藏成功")){
            model.addAttribute("result","加入购物车成功");
            Result mycartResult = goodsService.findGoodsByUserId(Long.valueOf(request.getSession().getAttribute("userId").toString()));
            model.addAttribute("enshrineList",mycartResult.getData());
            return "mycart";
        }
        model.addAttribute("result",result.getMessage());
        Result goodsResult= goodsService.findByGoodsId(goodsId);
        model.addAttribute("goods",goodsResult.getData());
        return "shopping-info";
    }
    //增加购买
    @RequestMapping("purchase")
    public String addpurchase(Long goodsId, Model model){
        Result result=goodsService.buyGoods(Long.valueOf(request.getSession().getAttribute("userId").toString()),goodsId);
        if(result.getMessage().equals("购买成功")){
            model.addAttribute("result",result.getMessage());
            Result orderResult = goodsService.findGoodsExc();
            return goodsService.returnPageList((List<Goods>) orderResult.getData(),1,20,true,model);
        }
        model.addAttribute("result",result.getMessage());
        Result goodsResult= goodsService.findByGoodsId(goodsId);
        model.addAttribute("goods",goodsResult.getData());
        return "shopping-info";
    }

}
