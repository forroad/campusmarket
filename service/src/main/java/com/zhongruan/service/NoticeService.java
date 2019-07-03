package com.zhongruan.service;

import com.zhongruan.bean.response.Result;
import com.zhongruan.bean.Notice;

import java.util.List;

public interface NoticeService {

    //新增公告
    Result insertNotice(long adminId,String noticeContent );
    //删除公告
    Result deleteNotice(long noticeId);
    //查询所有公告
    Result findAllNoticeOrderByTimeDesc();

}
