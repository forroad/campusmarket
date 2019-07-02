package com.zhongruan.bean;

import java.util.Date;

public class Message {
    private long messageId;
    private long goodsId;
    private long userId;
    private Date messageTime;
    private String messageContent;

    public Message() {
    }

    public Message(long goodsId, long userId, Date messageTime, String messageContent) {
        this.goodsId = goodsId;
        this.userId = userId;
        this.messageTime = messageTime;
        this.messageContent = messageContent;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(long goodsId) {
        this.goodsId = goodsId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", goodsId=" + goodsId +
                ", userId=" + userId +
                ", messageTime=" + messageTime +
                ", messageContent='" + messageContent + '\'' +
                '}';
    }
}
