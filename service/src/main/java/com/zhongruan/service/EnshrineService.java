package com.zhongruan.service;

import com.zhongruan.bean.response.Result;

public interface EnshrineService {
    /**
     *  添加收藏
     * @param userId 用户Id
     * @param goodsId 收藏商品Id
     * @return 收藏结果
     */
    Result addEnshrine(long userId,long goodsId);


    /**
     *  查询用户的收藏列表
     * @param userId 用户Id
     * @return Result.messge:收藏状态，result.data：查询的结果集
     */
    Result findUserEnshrine(long userId);


    /**
     *  删除用户的收藏
     * @param enshrineId 收藏Id
     * @return 删除结果
     */
    Result deleteUserEnshrine(long enshrineId);

    /**
     *  删除收藏
     * @param goodsId 商品id
     * @param userId 用户id
     * @return 删除结果
     */
    Result delEnshrine(long goodsId,long userId);
}
