package com.zhongruan.service;

import com.zhongruan.bean.Goods;
import com.zhongruan.bean.response.Result;

import java.util.List;

public interface GoodsService {
    /**
     * 上架商品
     * @param userId 上架的用户Id
     * @param typeId 商品所属类型Id
     * @param goodsName 商品名
     * @param goodsContent 商品描述
     * @param goodsNumber 商品数量
     * @param goodsOrginalPrice 商品原价
     * @param goodsNowPrice 商品售价
     * @param goodsPopularity 商品人气
     * @param goodsStatus 商品新旧程度
     * @param goodsImage 商品图片路径
     * @return 上架信息
     */
    Result addGoods(long userId,long typeId,String goodsName,String goodsContent,int goodsNumber,
                    double goodsOrginalPrice,double goodsNowPrice,int goodsPopularity,int goodsStatus,String goodsImage);


    /**
     *  下架商品
     * @param goodsId 商品Id
     * @return 下架信息
     */
    Result subGoods(long goodsId);


    /**
     *  购买商品
     * @param userId 用户id
     * @param goodsId 货物id
     * @return 购买信息
     */
    Result buyGoods(long userId,long goodsId);

    /**
     *  查询商品详细信息
     * @param goodsId 商品Id
     * @return 查询的商品信息
     */
    Result findByGoodsId(long goodsId);

    /**
     * 通过名称模糊查询商品
     * @param goodsName 关键词
     * @return 查询结果
     */
    Result findByGoodsNameLike(String goodsName);

    /**
     * 通过价格区间筛选商品
     * @param startPrice 起始价格
     * @param endPrice 终止价格
     * @return  筛选结果
     */
    Result findByGoodsNowPriceBetween(double startPrice,double endPrice);

    /**
     *  通过商品人气降序查询商品
     * @return 返回的结果集
     */
    Result findByGoodsPopularityDesc();

    /**
     *  通过商品人气升序查询商品
     * @return 返回的结果集
     */
    Result findByGoodsPopularityAsc();

    /**
     *  通过商品新旧程序降序查询商品
     * @return 返回的结果集
     */
    Result findByGoodsStatusDesc();

    /**
     *  通过商品新旧程度升序查询商品
     * @return
     */
    Result findByGoodsStatusAsc();

    /**
     *  查询某个用户购买的商品
     * @param userId 用户ID
     * @return 查询结果
     */
    Result findByIsBuyAndUserId(long userId);
}
