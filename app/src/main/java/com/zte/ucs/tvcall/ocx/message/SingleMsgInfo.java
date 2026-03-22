package com.zte.ucs.tvcall.ocx.message;

/* loaded from: classes2.dex */
public class SingleMsgInfo {
    private String receiverUri = "";
    private String messageId = "";
    private String text = "";
    private String dateTime = "";
    private String sendUrl = "";
    private int receipt = 0;
    private int msgFlag = 0;
    private int barcycleTime = 0;

    public int getBarcycleTime() {
        return this.barcycleTime;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public String getMessageId() {
        return this.messageId;
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

    public String getText() {
        return this.text;
    }

    public void setBarcycleTime(int i) {
        this.barcycleTime = i;
    }

    public void setDateTime(String str) {
        this.dateTime = str;
    }

    public void setMessageId(String str) {
        this.messageId = str;
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

    public void setText(String str) {
        this.text = str;
    }
}
