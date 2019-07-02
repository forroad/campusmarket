package com.zhongruan.dao;

import com.zhongruan.bean.Purchase;

import java.util.List;

public interface PurchaseDao {
    /**
     *  新增订单
     * @param purchase 订单实体
     * @return ...
     */
    int insertPurchase(Purchase purchase);

    /**
     *  删除订单
     * @param purchaseId 需要删除的订单Id
     * @return ...
     */
    int deletePurchase(long purchaseId);

    /**
     *  通过用户Id查询订单,并按照时间排序，时间近的在前
     * @param userId 用户id
     * @return 查询结果集
     */
    List<Purchase> findByUserIdOrderByTimeDesc(long userId);
}
