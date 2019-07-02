package com.zhongruan.bean;

public class Admin {
    private long adminId;
    private String adminAccount;
    private String adminPassword;
    private String adminRealName;
    private long adminTelephone;
    private String adminImage;

    public Admin() {
    }

    public Admin(String adminAccount, String adminPassword, String adminRealName, long adminTelephone, String adminImage) {
        this.adminAccount = adminAccount;
        this.adminPassword = adminPassword;
        this.adminRealName = adminRealName;
        this.adminTelephone = adminTelephone;
        this.adminImage = adminImage;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminRealName() {
        return adminRealName;
    }

    public void setAdminRealName(String adminRealName) {
        this.adminRealName = adminRealName;
    }

    public long getAdminTelephone() {
        return adminTelephone;
    }

    public void setAdminTelephone(long adminTelephone) {
        this.adminTelephone = adminTelephone;
    }

    public String getAdminImage() {
        return adminImage;
    }

    public void setAdminImage(String adminImage) {
        this.adminImage = adminImage;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminAccount='" + adminAccount + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminRealName='" + adminRealName + '\'' +
                ", adminTelephone=" + adminTelephone +
                ", adminImage='" + adminImage + '\'' +
                '}';
    }
}
