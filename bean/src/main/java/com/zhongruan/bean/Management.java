package com.zhongruan.bean;

public class Management {
    private long manageId;
    private long userId;
    private long adminId;
    private int manageType;

    public Management() {
    }

    public Management(long userId, long adminId, int manageType) {
        this.userId = userId;
        this.adminId = adminId;
        this.manageType = manageType;
    }

    public long getManageId() {
        return manageId;
    }

    public void setManageId(long manageId) {
        this.manageId = manageId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public int getManageType() {
        return manageType;
    }

    public void setManageType(int manageType) {
        this.manageType = manageType;
    }

    @Override
    public String toString() {
        return "Management{" +
                "manageId=" + manageId +
                ", userId=" + userId +
                ", adminId=" + adminId +
                ", manageType=" + manageType +
                '}';
    }
}
