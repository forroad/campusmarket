package com.zhongruan.bean.util;


import org.springframework.util.DigestUtils;

public class AccountUtils {
    /**
     *  采用Md5加密加密密码
     * @param password 需要加密的密码
     * @return 加密后的密码
     */
    public static String encoding(String password){
        return DigestUtils.md5DigestAsHex(password.getBytes());
    }
}
