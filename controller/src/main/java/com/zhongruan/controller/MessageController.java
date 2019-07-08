package com.zhongruan.controller;

import com.zhongruan.bean.response.Result;
import com.zhongruan.service.GoodsService;
import com.zhongruan.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("message")
public class MessageController {
    private MessageService messageService;
    private HttpSession session;
    private GoodsService goodsService;

    @Autowired
    public MessageController(MessageService messageService, HttpSession session, GoodsService goodsService) {
        this.messageService = messageService;
        this.session = session;
        this.goodsService = goodsService;
    }

    @RequestMapping("addmessage")
    public String addMessage(Long goodsId, String messageContent, Model model){
        System.out.println("goodsId:" + goodsId);
        System.out.println("messageContent:" + messageContent);
        long userId = Long.valueOf(session.getAttribute("userId").toString());
        Result result = messageService.messageGoods(userId,goodsId,messageContent);
        if(result.getMessage().equals("留言成功")){
            Result messageResult = messageService.findGoodsMessage(goodsId);
            model.addAttribute("messageList",messageResult.getData());
            Result goodsResult= goodsService.findByGoodsId(goodsId);
            model.addAttribute("goods",goodsResult.getData());
            return "shopping-info";
        }
        model.addAttribute("result",result.getMessage());
        Result goodsResult= goodsService.findByGoodsId(goodsId);
        model.addAttribute("goods",goodsResult.getData());
        return "shopping-info";
    }
}
