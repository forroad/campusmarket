package com.zhongruan.service.impl;

import com.zhongruan.bean.Purchase;
import com.zhongruan.bean.response.Result;
import com.zhongruan.dao.PurchaseDao;
import com.zhongruan.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    PurchaseDao purchaseDao;
    @Override
    public Result findUserOrder(long userId) {
        List<Purchase>purchases=purchaseDao.findByUserIdOrderByTimeDesc(userId);
        return new Result("查询订单成功",purchases);
    }
}
