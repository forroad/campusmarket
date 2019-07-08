package com.zhongruan.dao;

import com.zhongruan.bean.Goods;

import java.util.List;

public interface GoodsDao {
    /**
     * 新增实体
     * @param goods 商品实体
     * @return ...
     */
    int insertGoods(Goods goods);

    /**
     *  删除商品
     * @param goodsId 商品id
     * @return ...
     */
    int deleeGoods(long goodsId);

    /**
     *  通过商品Id查询商品
     * @param goodsId 商品Id
     * @return 查询的结果
     */
    Goods findByGoodsId(long goodsId);

    /**
     *  通过商品名称模糊查询商品
     * @param goodsName 名称关键词
     * @return
     */
    List<Goods> findByGoodsNameLike(String goodsName);

    /**
     *  通过价格区间查询商品
     * @param startPrice 起始价格
     * @param endPrice 终止价格
     * @return 符合条件的商品列表
     */
    List<Goods> findByGoodsNowPriceBetween(double startPrice,double endPrice);

    /**
     *  通过商品人气降序查询商品
     * @return 返回的结果集
     */
    List<Goods> findByGoodsPopularityDesc();

    /**
     *  通过商品人气升序查询商品
     * @return 返回的结果集
     */
    List<Goods> findByGoodsPopularityAsc();

    /**
     *  通过商品新旧程序降序查询商品
     * @return 返回的结果集
     */
    List<Goods> findByGoodsStatusDesc();

    /**
     *  通过商品新旧程度升序查询商品
     * @return
     */
    List<Goods> findByGoodsStatusAsc();

    /**
     * 查询某个用户购买的商品
     * @param userId 用户id
     * @return 查询结果
     */
    List<Goods> findByIsBuyAndUserId(long userId);


    /**
     * 查询用户发布并且未被购买的商品
     * @param userId 发布商品的用户
     * @return 查询结果集
     */
    List<Goods> findByNotByAndAdd(long userId);


    /**
     *  查询用户收藏的id
     * @param userId 用户id
     * @return ...
     */
    List<Goods>  findGoodsByUserId(long userId);

    /**
     *  查询不在订单之中的商品
     * @return
     */
    List<Goods> findGoodsExc();

    /**
     *   通过类型查询商品
     * @param typeId 类型id
     * @return 查询结果
     */
    List<Goods> findGoodsByType(long typeId);

    /**
     * 通过价格降序查询商品
     * @return 查询结果
     */
    List<Goods> findByGoodsPriceDesc();

    /**
     * 通过价格升序查询商品
     * @return 查询结果
     */
    List<Goods> findByGoodsPriceAsc();
}
