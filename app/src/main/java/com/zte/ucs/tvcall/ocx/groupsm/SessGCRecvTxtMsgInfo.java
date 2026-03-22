package com.zte.ucs.tvcall.ocx.groupsm;

/* loaded from: classes2.dex */
public class SessGCRecvTxtMsgInfo {
    private String contactId;
    private String chatId = "";
    private String messageId = "";
    private String text = "";
    private String CPIMcc = "";
    private String deliverTime = "";

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

    public String getMessageId() {
        return this.messageId;
    }

    public String getText() {
        return this.text;
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

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setText(String str) {
        this.text = str;
    }
}
