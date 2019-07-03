package com.zhongruan.service;

import com.zhongruan.bean.response.Result;

public interface AdminService {

    /**
     *  增加管理员
     * @param adminAccount 管理员用户名
     * @param adminPassword 管理员密码
     * @param adminRealName 管理员真实姓名
     * @param adminTelephone 管理员电话号码
     * @param adminImage 管理员头像路径
     * @return 添加信息
     */
    Result addAdmin(String adminAccount,String adminPassword,String adminRealName,String adminTelephone,String adminImage);

}
