package com.zhongruan.service.impl;

import com.zhongruan.bean.Enshrine;
import com.zhongruan.bean.response.Result;
import com.zhongruan.dao.EnshrineDao;
import com.zhongruan.service.EnshrineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Date;
import java.util.List;

@Service
public class EnshrineServiceImpl implements EnshrineService {
    @Autowired
    EnshrineDao enshrineDao;
    @Override
    public Result addEnshrine(long userId, long goodsId) {
        Enshrine enshrine = enshrineDao.findByUserIdAndGoodsId(goodsId,userId);
        if(enshrine != null){
            return new Result("已收藏",enshrine);
        }
        Date date   =  new   java.util.Date();
        Enshrine enshrine1=new Enshrine(userId,goodsId,date);
        enshrineDao.insertEnshrine(enshrine1);
        return new Result("增加收藏成功",enshrine1);
    }

    @Override
    public Result findUserEnshrine(long userId) {
        List<Enshrine> enshrine=enshrineDao.findByUserId(userId);
        return new Result("增加收藏成功",enshrine);
    }

    @Override
    public Result deleteUserEnshrine(long enshrineId) {
        enshrineDao.deleteEnshrine(enshrineId);
        return new Result("删除收藏成功",null);
    }

    @Override
    public Result delEnshrine(long goodsId, long userId) {
        enshrineDao.delEnshrine(goodsId,userId);
        return new Result("删除收藏成功",null);
    }
}
