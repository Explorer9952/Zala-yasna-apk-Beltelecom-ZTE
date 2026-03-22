package com.zte.ucs.tvcall.ocx.message;

/* loaded from: classes2.dex */
public class SingleMultMsgInfo {
    private String sendUrl = "";
    private String receiverUri = "";
    private String messageId = "";
    private String file = "";
    private int timeLen = 0;
    private int receipt = 0;
    private int messageType = 0;
    private String dateTime = "";
    private int msgFlag = 0;
    private int barcycleTime = 0;

    public int getBarcycleTime() {
        return this.barcycleTime;
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

    public int getReceipt() {
        return this.receipt;
    }

    public String getReceiverUri() {
        return this.receiverUri;
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

    public void setReceiverUri(String str) {
        this.receiverUri = str;
    }

    public void setSendUrl(String str) {
        this.sendUrl = str;
    }

    public void setTimeLen(int i) {
        this.timeLen = i;
    }
}
