package com.zhongruan.bean;

import java.util.Date;

public class Enshrine {
    private long enshrineId;
    private long userId;
    private long goodsId;
    private Date enshrineTime;

    public Enshrine() {
    }

    public Enshrine(long userId, long goodsId, Date enshrineTime) {
        this.userId = userId;
        this.goodsId = goodsId;
        this.enshrineTime = enshrineTime;
    }

    public long getEnshrineId() {
        return enshrineId;
    }

    public void setEnshrineId(long enshrineId) {
        this.enshrineId = enshrineId;
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

    public Date getEnshrineTime() {
        return enshrineTime;
    }

    public void setEnshrineTime(Date enshrineTime) {
        this.enshrineTime = enshrineTime;
    }

    @Override
    public String toString() {
        return "Enshrine{" +
                "enshrineId=" + enshrineId +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                ", enshrineTime=" + enshrineTime +
                '}';
    }
}
