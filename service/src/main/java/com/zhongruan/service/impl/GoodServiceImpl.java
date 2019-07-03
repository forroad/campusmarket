package com.zhongruan.service.impl;

import com.zhongruan.bean.*;
import com.zhongruan.bean.response.Result;
import com.zhongruan.dao.*;
import com.zhongruan.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GoodServiceImpl implements GoodsService {
    @Autowired
    GoodsDao goodsDao;
    @Autowired
    MessageDao messageDao;
    @Autowired
    EnshrineDao enshrineDao;
    @Autowired
    UserDao userDao;
    @Autowired
    PurchaseDao purchaseDao;


    @Override
    public Result addGoods(long userId, long typeId, String goodsName, String goodsContent, int goodsNumber, double goodsOrginalPrice, double goodsNowPrice, int goodsPopularity, int goodsStatus, String goodsImage) {
        Goods goods = new Goods(userId,typeId,goodsName,goodsContent,goodsNumber,goodsOrginalPrice,goodsNowPrice,goodsPopularity,goodsStatus,goodsImage);
        goodsDao.insertGoods(goods);
        return new Result("增加成功",goods);
    }

    @Override
    public Result subGoods(long goodsId) {
        Goods goods = goodsDao.findByGoodsId(goodsId);
        //首先删除商品留言
        List<Message> messages = messageDao.findByGoodsId(goodsId);
        if(messages.size() > 0){
            for (Message message : messages) {
                messageDao.deleteMessage(message.getMessageId());
            }
        }
        //删除用户收藏
        List<Enshrine> enshrines = enshrineDao.findByGoodsId(goodsId);
        if(enshrines.size() > 0){
            for (Enshrine enshrine: enshrines
                 ) {
                enshrineDao.deleteEnshrine(enshrine.getEnshrineId());
            }
        }
        //删除商品
        goodsDao.deleeGoods(goodsId);
        return new Result("下架成功",goods);
    }

    @Override
    public Result buyGoods(long userId, long goodsId) {
        User user = userDao.findByUserId(userId);
        if(user == null){
            return new Result("用户不存在",null);
        }
        Goods goods = goodsDao.findByGoodsId(goodsId);
        if(goods == null){
            return new Result("商品不存在",null);
        }
        Purchase purchase = new Purchase(userId,goodsId,new Date(System.currentTimeMillis()));
        purchaseDao.insertPurchase(purchase);
        return new Result("购买成功",purchase);
    }
    //通过ID查询商品
    @Override
    public Result findByGoodsId(long goodsId) {
        Goods goods=goodsDao.findByGoodsId(goodsId);
        return new Result("查询成功",goods);
    }
    //通过商品名模糊查询
    @Override
    public Result findByGoodsNameLike(String goodsName) {
        List<Goods>goods=goodsDao.findByGoodsNameLike(goodsName);
        return new Result("查询成功",goods);
    }
    //通过价格区间查询
    @Override
    public Result findByGoodsNowPriceBetween(double startPrice, double endPrice) {
        List<Goods>goods=goodsDao.findByGoodsNowPriceBetween(startPrice,endPrice);
        return new Result("查询成功",goods);
    }
    //根据人气降序查询
    @Override
    public Result findByGoodsPopularityDesc() {
        List<Goods>goods=goodsDao.findByGoodsPopularityDesc();
        return  new Result("查询成功",goods);
    }
    //根据人气降序查询
    @Override
    public Result findByGoodsPopularityAsc() {
        List<Goods>goods=goodsDao.findByGoodsPopularityAsc();
        return  new Result("查询成功",goods);
    }
//通过商品新旧程序降序查询商品
    @Override
    public Result findByGoodsStatusDesc() {
       List<Goods> goods=goodsDao.findByGoodsStatusDesc();
        return  new Result("查询成功",goods);
    }
//通过商品新旧程序降序查询商品
    @Override
    public Result findByGoodsStatusAsc() {
        List<Goods> goods=goodsDao.findByGoodsStatusAsc();
        return  new Result("查询成功",goods);
    }
}
