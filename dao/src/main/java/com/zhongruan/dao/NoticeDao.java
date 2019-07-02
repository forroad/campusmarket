package com.zhongruan.dao;

import com.zhongruan.bean.Notice;

import java.util.List;

public interface NoticeDao {
    /**
     * 新增公告
     * @param notice 公告实体
     * @return ...
     */
    int insertNotice(Notice notice);

    /**
     * 删除公告
     * @param noticeId 公告Id
     * @return ...
     */
    int deleteNotice(long noticeId);

    /**
     *  获取所有公告
     * @return 返回所有公告列表
     */
    List<Notice> findAllNoticeOrderByTimeDesc();
}
