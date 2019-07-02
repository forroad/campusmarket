package com.zhongruan.bean;

public class Goods {
    private long goodsId;
    private long userId;
    //商品类别Id
    private long typeId;
    //商品名称
    private String goodsName;
    //商品描述
    private String goodsContent;
    //商品数量
    private int goodsNumber;
    //商品原价
    private double goodsOrginalPrice;
    //商品售价
    private double goodsNowPrice;
    //商品人气
    private int goodsPopularity;
    //商品新旧程度
    private int goodsStatus;
    //商品图片存储路径
    private String goodsImage;

    public Goods() {
    }

    public Goods(long userId, long typeId, String goodsName, String goodsContent, int goodsNumber, double goodsOrginalPrice, double goodsNowPrice, int goodsPopularity, int goodsStatus, String goodsImage) {
        this.userId = userId;
        this.typeId = typeId;
        this.goodsName = goodsName;
        this.goodsContent = goodsContent;
        this.goodsNumber = goodsNumber;
        this.goodsOrginalPrice = goodsOrginalPrice;
        this.goodsNowPrice = goodsNowPrice;
        this.goodsPopularity = goodsPopularity;
        this.goodsStatus = goodsStatus;
        this.goodsImage = goodsImage;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsContent() {
        return goodsContent;
    }

    public void setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public double getGoodsOrginalPrice() {
        return goodsOrginalPrice;
    }

    public void setGoodsOrginalPrice(double goodsOrginalPrice) {
        this.goodsOrginalPrice = goodsOrginalPrice;
    }

    public double getGoodsNowPrice() {
        return goodsNowPrice;
    }

    public void setGoodsNowPrice(double goodsNowPrice) {
        this.goodsNowPrice = goodsNowPrice;
    }

    public int getGoodsPopularity() {
        return goodsPopularity;
    }

    public void setGoodsPopularity(int goodsPopularity) {
        this.goodsPopularity = goodsPopularity;
    }

    public int getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(int goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", userId=" + userId +
                ", typeId=" + typeId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsContent='" + goodsContent + '\'' +
                ", goodsNumber=" + goodsNumber +
                ", goodsOrginalPrice=" + goodsOrginalPrice +
                ", goodsNowPrice=" + goodsNowPrice +
                ", goodsPopularity=" + goodsPopularity +
                ", goodsStatus='" + goodsStatus + '\'' +
                ", goodsImage='" + goodsImage + '\'' +
                '}';
    }
}
