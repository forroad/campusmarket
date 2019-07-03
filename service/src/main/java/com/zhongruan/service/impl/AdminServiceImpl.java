package com.zhongruan.service.impl;

import com.zhongruan.bean.Admin;
import com.zhongruan.bean.response.Result;
import com.zhongruan.dao.AdminDao;
import com.zhongruan.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;
    @Override
    public Result addAdmin(String adminAccount, String adminPassword, String adminRealName, Long adminTelephone, String adminImage) {
         Admin admin=new Admin(adminAccount,adminPassword,adminRealName,adminTelephone,adminImage);
         adminDao.insertAdmin(admin);
         return new Result("新增成功",admin);
    }
}
