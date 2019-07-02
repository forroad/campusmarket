package com.zhongruan.dao;

import com.zhongruan.bean.User;

public interface UserDao {
    User findByUserAccount(String userAccount);
}
