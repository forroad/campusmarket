package com.zhongruan.dao;

import com.zhongruan.bean.User;

import java.util.List;

public interface UserDao {
    /**
     * 添加用户
     * @param user 用户实体
     * @return 默认返回数据，影响行数
     */
    int insertUser(User user);

    /**
     * 删除用户
     * @param userId 用户id
     * @return ...
     */
    int deleteUser(long userId);

    /**
     *  通过用户Id查询用户
     * @param userId 用户Id
     * @return 查询到的用户
     */
    User findByUserId(long userId);

    /**
     * 通过用户账号查询用户
     * @param userAccount 用户账号
     * @return 查询到的用户实体
     */
    User findByUserAccount(String userAccount);

    /**
     * 通过真实姓名模糊查询用户
     * @param realname 用户真实姓名
     * @return 查询到的用户列表
     */
    List<User> findByRealname(String realname);

    /**
     *  通过电话号码查询用户
     * @param telephone 用户电话号码
     * @return 查询到的用户
     */
    User findByTelephone(long telephone);

    /**
     *  修改用户信息
     * @param user 修改用户的新信息
     * @return ....
     */
    int modifyUser(User user);


}
