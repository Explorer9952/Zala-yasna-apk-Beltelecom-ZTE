package com.zte.ucs.tvcall.ocx.groupsm;

/* loaded from: classes2.dex */
public class SessGroupChatInfo {
    private String chatId = "";
    private String messageId = "";
    private String subject = "";
    private String sessionId = "";
    private String contactId = "";

    public String getChatId() {
        return this.chatId;
    }

    public String getContactId() {
        return this.contactId;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setChatId(String str) {
        this.chatId = str;
    }

    public void setContactId(String str) {
        this.contactId = str;
    }

    public void setMessageId(String str) {
        this.messageId = str;
    }

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSubject(String str) {
        this.subject = str;
    }
}
