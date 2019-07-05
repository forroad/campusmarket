package com.zhongruan.service.impl;

import com.zhongruan.bean.Goods;
import com.zhongruan.bean.Message;
import com.zhongruan.bean.User;
import com.zhongruan.bean.response.Result;
import com.zhongruan.dao.GoodsDao;
import com.zhongruan.dao.MessageDao;
import com.zhongruan.dao.UserDao;
import com.zhongruan.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    UserDao userDao;
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    MessageDao messageDao;

    @Override
    public Result messageGoods(long userId, long goodsId, String messageContext) {
        User user = userDao.findByUserId(userId);
        if(user == null){
            return new Result("用户不存在",null);
        }
        Goods goods = goodsDao.findByGoodsId(goodsId);
        if(goods == null){
            return new Result("商品不存在",null);
        }
        Message message = new Message(goodsId,userId,new Date(System.currentTimeMillis()),messageContext);
        messageDao.insertMessage(message);
        return new Result("留言成功",message);
    }

    @Override
    public Result findGoodsMessage(long goodsId) {
        List<Message> message=messageDao.findByGoodsId(goodsId);
        return new Result("查询成功",message);
    }

    @Override
    public Result findUserMessage(long userId) {

        List<Message> message=messageDao.findByGoodsId(userId);
        return new Result("查询成功",message);
    }

    @Override
    public Result deleteMessage(long messageId) {
        messageDao.deleteMessage(messageId);
        return  new Result("删除成功",null);
    }
}
