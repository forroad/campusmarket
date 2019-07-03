package com.zhongruan.service.impl;

import com.zhongruan.bean.Notice;
import com.zhongruan.bean.response.Result;
import com.zhongruan.dao.NoticeDao;
import com.zhongruan.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeDao NoticeDao;

   //新增公告
    @Override
    public Result insertNotice(long adminId, String noticeContent) {
        Date date   =  new   java.util.Date();
        Notice notice=new Notice(adminId,date,noticeContent);
        NoticeDao.insertNotice(notice);
        return new Result("增加成功",notice);
    }
    //删除公告
    @Override
    public Result deleteNotice(long noticeId) {
        NoticeDao.deleteNotice(noticeId);
        return new Result("删除成功",null);
    }

    @Override
    public Result findAllNoticeOrderByTimeDesc() {
        List <Notice> notices=NoticeDao.findAllNoticeOrderByTimeDesc();
        return new Result("查询成功",notices);
    }
}
