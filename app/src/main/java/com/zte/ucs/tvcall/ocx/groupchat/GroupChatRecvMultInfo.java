package com.zte.ucs.tvcall.ocx.groupchat;

/* loaded from: classes2.dex */
public class GroupChatRecvMultInfo {
    private String chatId = "";
    private String messageId = "";
    private String sendUrl = "";
    private String dateTime = "";
    private String file = "";
    private String CPIMcc = "";
    private String smallPic = "";
    private int messageType = 0;
    private int timeLen = 0;
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

    public String getDateTime() {
        return this.dateTime;
    }

    public String getFile() {
        return this.file;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public int getMsgFlag() {
        return this.msgFlag;
    }

    public String getSendUrl() {
        return this.sendUrl;
    }

    public String getSmallPic() {
        return this.smallPic;
    }

    public int getTimeLen() {
        return this.timeLen;
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

    public void setDateTime(String str) {
        this.dateTime = str;
    }

    public void setFile(String str) {
        this.file = str;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setMessageType(int i) {
        this.messageType = i;
    }

    public void setMsgFlag(int i) {
        this.msgFlag = i;
    }

    public void setSendUrl(String str) {
        this.sendUrl = str;
    }

    public void setSmallPic(String str) {
        this.smallPic = str;
    }

    public void setTimeLen(int i) {
        this.timeLen = i;
    }
}
