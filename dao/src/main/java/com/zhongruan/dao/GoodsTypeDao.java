package com.zhongruan.dao;

public interface GoodsTypeDao {
    /**
     * 新增商品类别
     * @param typeName 类别名称
     * @return ...
     */
    int insertGoodsType(String typeName);

    /**
     * 删除商品类别
     * @param typeId 类别ID
     * @return ...
     */
    int deleteGoodsType(long typeId);
}
