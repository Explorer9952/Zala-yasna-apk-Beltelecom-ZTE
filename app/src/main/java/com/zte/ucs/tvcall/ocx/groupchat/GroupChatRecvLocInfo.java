package com.zte.ucs.tvcall.ocx.groupchat;

/* loaded from: classes2.dex */
public class GroupChatRecvLocInfo {
    private String chatId = "";
    private String longitude = "";
    private String latidute = "";
    private String radius = "";
    private String locationName = "";
    private String messageId = "";
    private String senderUrl = "";
    private String sendTime = "";
    private int msgFlag = 0;
    private int barcycleTime = 0;

    public int getBarcycleTime() {
        return this.barcycleTime;
    }

    public String getChatId() {
        return this.chatId;
    }

    public String getLatidute() {
        return this.latidute;
    }

    public String getLocationName() {
        return this.locationName;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getMsgFlag() {
        return this.msgFlag;
    }

    public String getRadius() {
        return this.radius;
    }

    public String getSendTime() {
        return this.sendTime;
    }

    public String getSenderUrl() {
        return this.senderUrl;
    }

    public void setBarcycleTime(int i) {
        this.barcycleTime = i;
    }

    public void setChatId(String str) {
        this.chatId = str;
    }

    public void setLatidute(String str) {
        this.latidute = str;
    }

    public void setLocationName(String str) {
        this.locationName = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setMsgFlag(int i) {
        this.msgFlag = i;
    }

    public void setRadius(String str) {
        this.radius = str;
    }

    public void setSendTime(String str) {
        this.sendTime = str;
    }

    public void setSenderUrl(String str) {
        this.senderUrl = str;
    }
}
