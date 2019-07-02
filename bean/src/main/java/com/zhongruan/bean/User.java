package com.zhongruan.bean;

public class User {
    private long userId;
    private String userAccount;
    private String userPassword;
    private String userImage;
    private String userRealName;
    private long userTelephone;
    private String address;

    public User() {
    }

    public User(String userAccount, String userPassword, String userImage, String userRealName, long userTelephone, String address) {
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.userImage = userImage;
        this.userRealName = userRealName;
        this.userTelephone = userTelephone;
        this.address = address;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserRealName() {
        return userRealName;
    }

    public void setUserRealName(String userRealName) {
        this.userRealName = userRealName;
    }

    public long getUserTelephone() {
        return userTelephone;
    }

    public void setUserTelephone(long userTelephone) {
        this.userTelephone = userTelephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userAccount='" + userAccount + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userImage='" + userImage + '\'' +
                ", userRealName='" + userRealName + '\'' +
                ", userTelephone=" + userTelephone +
                ", address='" + address + '\'' +
                '}';
    }
}
