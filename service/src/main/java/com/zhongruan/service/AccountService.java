package com.zhongruan.service;

import com.zhongruan.bean.User;
import com.zhongruan.bean.response.Result;

import java.util.List;

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

    /**
     *  通过用户Id查询用户
     * @param userId 用户Id
     * @return 查询到的用户
     */
    Result findByUserId(long userId);

    /**
     * 通过用户账号查询用户
     * @param userAccount 用户账号
     * @return 查询到的用户实体
     */
    Result findByUserAccount(String userAccount);

    /**
     * 通过真实姓名模糊查询用户
     * @param realname 用户真实姓名
     * @return 查询到的用户列表
     */
    Result findByRealname(String realname);

    /**
     *  通过电话号码查询用户
     * @param telephone 用户电话号码
     * @return 查询到的用户
     */
    Result findByTelephone(long telephone);
}
