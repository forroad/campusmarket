package com.zhongruan.bean;

import java.util.Date;

public class Purchase {
    private long purchaseId;
    private long userId;
    private long goodsId;
    private Date purchaseTime;

    public Purchase() {
    }

    public Purchase(long userId, long goodsId, Date purchaseTime) {
        this.userId = userId;
        this.goodsId = goodsId;
        this.purchaseTime = purchaseTime;
    }

    public long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseId=" + purchaseId +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                ", purchaseTime=" + purchaseTime +
                '}';
    }
}
