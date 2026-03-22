package com.zte.ucs.tvcall.ocx.groupchat;

/* loaded from: classes2.dex */
public class GCsetJoinChatAuditAuthInfo {
    private String chatId = "";
    private String token = "";
    private int groupVaildType = 1;

    public String getChatId() {
        return this.chatId;
    }

    public int getGroupVaildType() {
        return this.groupVaildType;
    }

    public String getToken() {
        return this.token;
    }

    public void setChatId(String str) {
        this.chatId = str;
    }

    public void setGroupVaildType(int i) {
        this.groupVaildType = i;
    }

    public void setToken(String str) {
        this.token = str;
    }
}
