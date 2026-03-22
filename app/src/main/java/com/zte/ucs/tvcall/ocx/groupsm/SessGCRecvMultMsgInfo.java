package com.zte.ucs.tvcall.ocx.groupsm;

/* loaded from: classes2.dex */
public class SessGCRecvMultMsgInfo {
    private String chatId = "";
    private String messageId = "";
    private String contactId = "";
    private String deliverTime = "";
    private String file = "";
    private String CPIMcc = "";
    private String smallPic = "";
    private int messageType = 0;
    private int timeLen = 0;

    public String getCPIMcc() {
        return this.CPIMcc;
    }

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

    public void setCPIMcc(String str) {
        this.CPIMcc = str;
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
