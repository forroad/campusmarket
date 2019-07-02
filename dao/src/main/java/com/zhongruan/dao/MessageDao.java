package com.zhongruan.dao;

import com.zhongruan.bean.Message;

import java.util.List;

public interface MessageDao {
    /**
     *  新增留言
     * @param message 留言实体
     * @return ...
     */
    int insertMessage(Message message);


    /**
     *  删除留言
     * @param messageId 要删除的留言id
     * @return ...
     */
    int deleteMessage(long messageId);

    /**
     *  通过商品id查询留言
     * @param goodsId 商品id
     * @return 查询结果
     */
    List<Message> findByGoodsId(long goodsId);

    /**
     *  通过用户Id查询留言
     * @param userId 留言的用户id
     * @return 查询结果集
     */
    List<Message> findByUserId(long userId);
}
