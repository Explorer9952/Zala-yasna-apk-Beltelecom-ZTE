package com.zte.ucs.tvcall.ocx.groupchat;

/* loaded from: classes2.dex */
public class GroupChatInfo {
    private String chatId = "";
    private String subject = "";
    private String sessionId = "";

    public String getChatId() {
        return this.chatId;
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

    public void setSessionId(String str) {
        this.sessionId = str;
    }

    public void setSubject(String str) {
        this.subject = str;
    }
}
