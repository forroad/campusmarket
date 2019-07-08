package com.zhongruan.dao;

import com.zhongruan.bean.Enshrine;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnshrineDao {
    /**
     * 新增收藏
     * @param enshrine 收藏实体
     * @return ...
     */
    int insertEnshrine(Enshrine enshrine);

    /**
     * 删除收藏
     * @param enshrineId 收藏的id
     * @return ...
     */
    int deleteEnshrine(long enshrineId);

    /**
     *  查询用户的收藏列表
     * @param userId 用户id
     * @return 查询的结果集
     */
    List<Enshrine> findByUserId(long userId);

    /**
     * 查询某件商品的收藏
     * @param goodsId 货物id
     * @return 查询结果
     */
    List<Enshrine> findByGoodsId(long goodsId);

    /**
     *  删除收藏
     * @param goodsId 商品id
     * @param userId 用户id
     * @return ...
     */
    int delEnshrine(@Param("goodsId")long goodsId, @Param("userId")long userId);

    /**
     * 通过商品id和用户Id查询收藏
     * @param goodsId 商品id
     * @param userId 用户id
     * @return 查询的结果
     */
    Enshrine findByUserIdAndGoodsId(@Param("goodsId")long goodsId, @Param("userId")long userId);
}
