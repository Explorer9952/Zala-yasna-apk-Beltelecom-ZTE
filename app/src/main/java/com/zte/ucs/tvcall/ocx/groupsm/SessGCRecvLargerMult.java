package com.zte.ucs.tvcall.ocx.groupsm;

/* loaded from: classes2.dex */
public class SessGCRecvLargerMult {
    private String chatId = "";
    private String messageId = "";
    private String contactId = "";
    private String file = "";
    private int fileLen = 0;
    private String deliverTime = "";
    private int timeLen = 0;
    private int messageType = 0;

    public String getChatId() {
        return this.chatId;
    }

    public String getContactId() {
        return this.contactId;
    }

    public String getDeliverTime() {
        return this.deliverTime;
    }

    public String getFile() {
        return this.file;
    }

    public int getFileLen() {
        return this.fileLen;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public int getTimeLen() {
        return this.timeLen;
    }

    public void setChatId(String str) {
        this.chatId = str;
    }

    public void setContactId(String str) {
        this.contactId = str;
    }

    public void setDeliverTime(String str) {
        this.deliverTime = str;
    }

    public void setFile(String str) {
        this.file = str;
    }

    public void setFileLen(int i) {
        this.fileLen = i;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setMessageType(int i) {
        this.messageType = i;
    }

    public void setTimeLen(int i) {
        this.timeLen = i;
    }
}
