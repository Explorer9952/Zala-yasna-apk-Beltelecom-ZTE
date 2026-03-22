package com.zte.ucs.tvcall.ocx.message;

/* loaded from: classes2.dex */
public class SingleSendMsgInfo {
    private int barcycleTime;
    private int length;
    private String receiverUri = "";
    private String messageId = "";
    private String text = "";
    private int receipt = 0;
    private int msgFlag = 0;

    public int getBarcycleTime() {
        return this.barcycleTime;
    }

    public int getLength() {
        return this.length;
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

    public String getText() {
        return this.text;
    }

    public void setBarcycleTime(int i) {
        this.barcycleTime = i;
    }

    public void setLength(int i) {
        this.length = i;
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

    public void setText(String str) {
        this.text = str;
    }
}
