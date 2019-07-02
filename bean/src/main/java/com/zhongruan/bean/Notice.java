package com.zhongruan.bean;

import java.util.Date;

public class Notice {
    private long noticeId;
    private long adminId;
    private Date noticeTime;
    private String noticeContent;

    public Notice() {
    }

    public Notice(long adminId, Date noticeTime, String noticeContent) {
        this.adminId = adminId;
        this.noticeTime = noticeTime;
        this.noticeContent = noticeContent;
    }


    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(long noticeId) {
        this.noticeId = noticeId;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "noticeId=" + noticeId +
                ", adminId=" + adminId +
                ", noticeTime=" + noticeTime +
                ", noticeContent='" + noticeContent + '\'' +
                '}';
    }
}


