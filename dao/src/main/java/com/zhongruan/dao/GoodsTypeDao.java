package com.zhongruan.dao;

import com.zhongruan.bean.GoodsType;

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

    /**
     * 通过类型名称查询类型
     * @param typeName 类型名
     * @return 查出的类型
     */
    GoodsType findByGoodsTypeName(String typeName);
}
