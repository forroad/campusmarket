package com.zhongruan.service;

import com.zhongruan.bean.response.Result;

public interface MessageService {

    /**
     *  用户留言
     * @param userId 留言的用户id
     * @param goodsId 商品id
     * @return 留言信息
     */
    Result messageGoods(long userId, long goodsId, String messageContext);

    /**
     *  查询商品的留言
     * @param goodsId 货物Id
     * @return 查询结果
     */
    Result findGoodsMessage(long goodsId);

    /**
     *  查询用户的留言
     * @param userId 用户Id
     * @return 查询结果
     */
    Result findUserMessage(long userId);

    /**
     * 删除留言
     * @param messageId 留言id
     * @return 删除结果
     */
    Result deleteMessage(long messageId);
}
