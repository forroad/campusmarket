package com.zhongruan.service;

import com.zhongruan.bean.response.Result;

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
     *  用户留言
     * @param userId 留言的用户id
     * @param goodsId 商品id
     * @return 留言信息
     */
    Result messageGoods(long userId,long goodsId,String messageContext);
}
