package com.zhongruan.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zhongruan.bean.*;
import com.zhongruan.bean.response.Result;
import com.zhongruan.dao.*;
import com.zhongruan.service.GoodsService;
import com.zhongruan.service.GoodsTypeService;
import com.zhongruan.service.MessageService;
import com.zhongruan.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
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
    @Autowired
    GoodsTypeDao goodsTypeDao;
    @Autowired
    HttpSession session;
    @Autowired
    NoticeService noticeService;


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
        //删除订单
        List<Purchase> purchaseList = purchaseDao.findByGoosId(goodsId);
        if(purchaseList.size() > 0){
            for (Purchase purchase:purchaseList) {
                purchaseDao.deletePurchase(purchase.getPurchaseId());
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
        List<Enshrine> enshrineList = enshrineDao.findByGoodsId(goodsId);
        if(enshrineList.size() > 0){
            for (Enshrine enshrine:enshrineList) {
                enshrineDao.deleteEnshrine(enshrine.getEnshrineId());
            }
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
        List<Goods> goods=goodsDao.findByGoodsNameLike(goodsName);
        return new Result("查询成功",goods);
    }
    //通过价格区间查询
    @Override
    public Result findByGoodsNowPriceBetween(double startPrice, double endPrice) {
        List<Goods> goods=goodsDao.findByGoodsNowPriceBetween(startPrice,endPrice);
        return new Result("查询成功",goods);
    }
    //根据人气降序查询
    @Override
    public Result findByGoodsPopularityDesc() {
        List<Goods> goods=goodsDao.findByGoodsPopularityDesc();
        System.out.println("size:" + goods.size() + "");
        return  new Result("查询成功",goods);
    }
    //根据人气降序查询
    @Override
    public Result findByGoodsPopularityAsc() {
        List<Goods> goods=goodsDao.findByGoodsPopularityAsc();
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

    @Override
    public Result findByIsBuyAndUserId(long userId) {
        return  new Result("查询成功",goodsDao.findByIsBuyAndUserId(userId));
    }

    @Override
    public Result findByNotBuyAndAdd(long userId) {
        return new Result("查询成功",goodsDao.findByNotByAndAdd(userId));
    }

    @Override
    public Result findGoodsByUserId(long userId) {
        List<Goods> goodsList= goodsDao.findGoodsByUserId(userId);

        return new Result("查询成功",goodsList);
    }

    @Override
    public Result findGoodsExc() {
        return new Result("查询成功",goodsDao.findGoodsExc());
    }

    @Override
    public Result findGoodsByType(String typeName) {
        GoodsType type = goodsTypeDao.findByGoodsTypeName(typeName);
        if(type == null){
            return new Result("类型不存在",null);
        }
        List<Goods> goodsList = goodsDao.findGoodsByType(type.getTypeId());
        return new Result("查询成功",goodsList);
    }

    @Override
    public Result findByGoodsPriceDesc() {
        List<Goods> goodsList= goodsDao.findByGoodsPriceDesc();
        return new Result("查询成功",goodsList);
    }

    @Override
    public Result findByGoodsPriceAsc() {
        List<Goods> goodsList= goodsDao.findByGoodsPriceAsc();
        return new Result("查询成功",goodsList);
    }

    @Override
    public String returnPageList(List<Goods> goodsList, int pageNum, int pageSize, Boolean isFirst,Model model) {
        if(isFirst) session.setAttribute("returnGoodsList",goodsList);
        else goodsList = (List<Goods>)session.getAttribute("returnGoodsList");
        int size = goodsList.size();
        int pageAllNum = (size-1)/pageSize + 1;
        if(pageNum < 1){
            pageNum = 1;
        }
        if(pageNum > pageAllNum){
            pageNum = pageAllNum;
        }
        session.setAttribute("pageNum",pageNum);
        int pageStart = (pageNum - 1) * pageSize;
        int pageEnd  = pageStart + pageSize;
        if(pageEnd > size){
            pageEnd = size;
        }
        goodsList  = goodsList.subList(pageStart,pageEnd);

        Result noticeResult = noticeService.findLastNotice();
        model.addAttribute("notice",noticeResult.getData());

        model.addAttribute("goodsList",goodsList);
        return "shopping";
    }
}
