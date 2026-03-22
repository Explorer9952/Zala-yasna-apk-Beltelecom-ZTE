package com.zte.ucs.tvcall.ocx.precall;

/* loaded from: classes2.dex */
public class PrecallSendMultMsgInfo {
    private int type;
    private String subject = "";
    private String contactId = "";
    private String messageId = "";
    private String file = "";
    private int priority = 0;
    private int messageType = 0;
    private int timeLen = 0;
    private int receipt = 0;

    public String getContactId() {
        return this.contactId;
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

    public int getPriority() {
        return this.priority;
    }

    public int getReceipt() {
        return this.receipt;
    }

    public String getSubject() {
        return this.subject;
    }

    public int getTimeLen() {
        return this.timeLen;
    }

    public int getType() {
        return this.type;
    }

    public void setContactId(String str) {
        this.contactId = str;
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

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setReceipt(int i) {
        this.receipt = i;
    }

    public void setSubject(String str) {
        this.subject = str;
    }

    public void setTimeLen(int i) {
        this.timeLen = i;
    }

    public void setType(int i) {
        this.type = i;
    }
}
