package com.zhongruan.service;

import com.zhongruan.bean.User;
import com.zhongruan.bean.response.Result;

public interface AccountService {
    /**
     * 登录
     * @param userAccount 用户名
     * @param userPassword 密码
     * @return 是否登陆成功
     */
    Result login(String userAccount, String userPassword);

    /**
     *  注册
     * @param userAccount 用户名
     * @param userPassword 用户密码
     * @param userImage 用户头像
     * @param userRealName 用户真实姓名
     * @param userTelephone 用户手机号
     * @param address 用户地址
     * @return 注册成功后的用户实体
     */
    Result  register(String userAccount,String userPassword,String userImage,String userRealName,long userTelephone,String address);


    /**
     * 修改用户个人信息
     * @param userAccount 要修改的用户账号
     * @param userPassword 是否修改密码？新密码：旧密码
     * @param userImage 是否修改头像？新头像路径：旧图像路径
     * @param userRealName 是否修改姓名？新姓名：旧姓名
     * @param userTelephone 是否修改电话号码？新电话：旧电话
     * @param address 是否修改地址？新地址：旧地址
     * @return 修改信息
     */
    Result modifyUser(String userAccount,String userPassword,String userImage,String userRealName,long userTelephone,String address);
}
