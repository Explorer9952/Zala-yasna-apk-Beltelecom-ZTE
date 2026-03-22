package com.zte.ucs.tvcall.ocx.groupchat;

/* loaded from: classes2.dex */
public class GroupChatMsgInfo {
    private String deliverTime;
    private String chatId = "";
    private String messageId = "";
    private String sendUrl = "";
    private String text = "";
    private String CPIMcc = "";
    private int msgFlag = 0;
    private int barcycleTime = 0;

    public int getBarcycleTime() {
        return this.barcycleTime;
    }

    public String getCPIMcc() {
        return this.CPIMcc;
    }

    public String getChatId() {
        return this.chatId;
    }

    public String getDeliverTime() {
        return this.deliverTime;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getMsgFlag() {
        return this.msgFlag;
    }

    public String getSendUrl() {
        return this.sendUrl;
    }

    public String getText() {
        return this.text;
    }

    public void setBarcycleTime(int i) {
        this.barcycleTime = i;
    }

    public void setCPIMcc(String str) {
        this.CPIMcc = str;
    }

    public void setChatId(String str) {
        this.chatId = str;
    }

    public void setDeliverTime(String str) {
        this.deliverTime = str;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setMsgFlag(int i) {
        this.msgFlag = i;
    }

    public void setSendUrl(String str) {
        this.sendUrl = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}
