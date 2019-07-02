package com.zhongruan.dao;

import com.zhongruan.bean.Admin;

public interface AdminDao {
    /**
     *  新增管理员
     * @param admin 管理员实体
     * @return ...
     */
    int insertAdmin(Admin admin);
}
