package com.zte.ucs.tvcall.ocx.message;

/* loaded from: classes2.dex */
public class SingleFileBase {
    private String filetranId = "";
    private String messageId = "";
    private String sendUrl = "";
    private String receiverUri = "";
    private int fileLen = 0;
    private int timeLen = 0;
    private String smallPic = "";
    private String dateTime = "";
    private String fileName = "";
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

    public int getReceipt() {
        return this.receipt;
    }

    public String getReceiverUri() {
        return this.receiverUri;
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

    public void setReceipt(int i) {
        this.receipt = i;
    }

    public void setReceiverUri(String str) {
        this.receiverUri = str;
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
