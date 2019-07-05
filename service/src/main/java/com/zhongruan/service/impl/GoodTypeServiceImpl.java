package com.zhongruan.service.impl;

import com.zhongruan.bean.response.Result;
import com.zhongruan.dao.GoodsTypeDao;
import com.zhongruan.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GoodTypeServiceImpl implements GoodsTypeService {
    @Autowired
    GoodsTypeDao goodsTypeDao;
    @Override
    //新增商品类别
    public Result addGoodsType(String typeName) {
        goodsTypeDao.insertGoodsType(typeName);
        return new Result("新增商品类别成功",null);
    }

    @Override
    public Result deleteGoodsType(long typeId) {
        goodsTypeDao.deleteGoodsType(typeId);
        return new Result("删除商品类别成功",null);
    }
}
