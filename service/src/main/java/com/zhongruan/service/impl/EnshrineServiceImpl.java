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
        Date date   =  new   java.util.Date();
        Enshrine enshrine=new Enshrine(userId,goodsId,date);
        enshrineDao.insertEnshrine(enshrine);
        return new Result("增加收藏成功",enshrine);
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
}
