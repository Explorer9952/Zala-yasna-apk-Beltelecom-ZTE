package com.zte.ucs.tvcall.ocx.groupsm;

/* loaded from: classes2.dex */
public class SessGCRecvMultBase {
    private String chatId = "";
    private String filetranId = "";
    private String messageId = "";
    private String contactId = "";
    private int fileLen = 0;
    private int timeLen = 0;
    private String smallPic = "";
    private String deliverTime = "";
    private String fileName = "";
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

    public int getFileLen() {
        return this.fileLen;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getFiletranId() {
        return this.filetranId;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getMessageType() {
        return this.messageType;
    }

    public String getSmallPic() {
        return this.smallPic;
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

    public void setFileLen(int i) {
        this.fileLen = i;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFiletranId(String str) {
        this.filetranId = str;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setMessageType(int i) {
        this.messageType = i;
    }

    public void setSmallPic(String str) {
        this.smallPic = str;
    }

    public void setTimeLen(int i) {
        this.timeLen = i;
    }
}
