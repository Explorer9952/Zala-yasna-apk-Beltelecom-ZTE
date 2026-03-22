package com.zte.ucs.tvcall.ocx.groupchat;

/* loaded from: classes2.dex */
public class GroupChatGetFileInfo {
    private String chatId = "";
    private String filetranId = "";
    private String messageId = "";
    private String sendUrl = "";
    private String fileName = "";
    private int fileLen = 0;
    private int position = 0;
    private String dateTime = "";
    private int timeLen = 0;
    private int messageType = 0;
    private int msgFlag = 0;
    private int barcycleTime = 0;
    private int getFileFlag = 0;

    public int getBarcycleTime() {
        return this.barcycleTime;
    }

    public String getChatId() {
        return this.chatId;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public int getFileLen() {
        return this.fileLen;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFiletranId() {
        return this.filetranId;
    }

    public int getGetFileFlag() {
        return this.getFileFlag;
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

    public int getPosition() {
        return this.position;
    }

    public String getSendUrl() {
        return this.sendUrl;
    }

    public int getTimeLen() {
        return this.timeLen;
    }

    public void setBarcycleTime(int i) {
        this.barcycleTime = i;
    }

    public void setChatId(String str) {
        this.chatId = str;
    }

    public void setDateTime(String str) {
        this.dateTime = str;
    }

    public void setFileLen(int i) {
        this.fileLen = i;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFiletranId(String str) {
        this.filetranId = str;
    }

    public void setGetFileFlag(int i) {
        this.getFileFlag = i;
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

    public void setPosition(int i) {
        this.position = i;
    }

    public void setSendUrl(String str) {
        this.sendUrl = str;
    }

    public void setTimeLen(int i) {
        this.timeLen = i;
    }
}
