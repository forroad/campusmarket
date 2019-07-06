package com.zhongruan.controller;

import com.google.gson.Gson;
import com.zhongruan.bean.User;
import com.zhongruan.bean.response.Result;
import com.zhongruan.dao.UserDao;
import com.zhongruan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {
    private Gson gson = new Gson();
    @Autowired
    UserDao userDao;
    @Autowired
    AccountService accountService;


    @GetMapping(value = "testinsert",produces = "application/json;charset=UTF-8")
    public String testInsert(){
        return gson.toJson(accountService.register("18198189635","123456","null","赵贻成",18198189635L,"贵州"));
    }

}
