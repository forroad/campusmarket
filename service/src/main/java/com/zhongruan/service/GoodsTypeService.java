package com.zhongruan.service;

import com.zhongruan.bean.response.Result;

public interface GoodsTypeService {
    /**
     * 添加商品类别
     * @param typeName 类别名称
     * @return 添加结果
     */
    Result addGoodsType(String typeName);

    /**
     * 删除商品类别
     * @param typeId 类别ID
     * @return 删除结果
     */
    Result deleteGoodsType(long typeId);
}
