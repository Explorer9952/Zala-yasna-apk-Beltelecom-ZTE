package com.zte.ucs.tvcall.ocx.message;

/* loaded from: classes2.dex */
public class SingleGetFileResp {
    private String messageId = "";
    private String sendUrl = "";
    private String file = "";
    private int fileLen = 0;
    private String dateTime = "";
    private int timeLen = 0;
    private int messageType = 0;
    private int receipt = 0;
    private int msgFlag = 0;
    private int barcycleTime = 0;
    private int getFileFlag = 0;

    public int getBarcycleTime() {
        return this.barcycleTime;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public String getFile() {
        return this.file;
    }

    public int getFileLen() {
        return this.fileLen;
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

    public int getReceipt() {
        return this.receipt;
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

    public void setDateTime(String str) {
        this.dateTime = str;
    }

    public void setFile(String str) {
        this.file = str;
    }

    public void setFileLen(int i) {
        this.fileLen = i;
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

    public void setReceipt(int i) {
        this.receipt = i;
    }

    public void setSendUrl(String str) {
        this.sendUrl = str;
    }

    public void setTimeLen(int i) {
        this.timeLen = i;
    }
}
