package com.zhongruan.service;

import com.zhongruan.bean.response.Result;

public interface PurchaseService {
    /**
     *  查询用户的订单
     * @param userId 用户id
     * @return 查询结果
     */
    Result findUserOrder(long userId);
}
